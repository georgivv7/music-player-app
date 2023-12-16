import {useEffect} from 'react'
import { Buffer } from 'buffer'
import { useNavigate, useSearchParams } from 'react-router-dom'
import { useDispatch } from 'react-redux'
import { login } from '../redux/features/authSlice'
import authorize  from '../links/authorize'
import token from '../links/token'

function Redirect() {    
  const [searchParams] = useSearchParams();
  const navigate = useNavigate();
  const dispatch = useDispatch();

  useEffect(() => {
    if(!searchParams?.get('code')){           
     
      window.location.href = authorize();
    }
  },[]);

  useEffect(() => {
      console.log('Code from search params:', searchParams?.get('code'));
      if(searchParams?.get('code')){
          window.sessionStorage.setItem('code', searchParams.get('code'));

          const client = `${import.meta.env.CLIENT}`;
          const secret = `${import.meta.env.SECRET}`;
          const headers = new Headers();
          headers.append('Content-type', 'application/json');
          headers.append('Authorization', `Basic ${Buffer.from(`${client}:${secret}`).toString('base64')}`);

          const url = token();

          fetch(url, {
              method: 'POST', 
              mode: 'cors',
              headers: headers,
          }).then(async (response) => {
              console.log('Token Response:', response);
              const token = await response.json();
              console.log('Received Token:', token);
              if(token?.id_token) {
                  console.log('Setting id_token:', token.id_token);
                  window.sessionStorage.setItem('id_token', token.id_token);
                  dispatch(login(token.id_token));
                  navigate('/discover');
              }
          }).catch((err) => {
              console.log('Fetch error:', err);
          })
      }
  }, []);

  return (
    <p>Redirecting ...</p>
  )
}

export default Redirect;