import React from 'react'
import { Link } from 'react-router-dom';
import { generateCodeVerifier, generateCodeChallenge } from '../pkce/pkce';

function Login() {
  const verifier = generateCodeVerifier();
  window.sessionStorage.setItem('codeVerifier', verifier);
  console.log(window.sessionStorage.getItem('codeVerifier'));
  const codeChallenge = generateCodeChallenge(verifier);
  window.sessionStorage.setItem('codeChallenge', codeChallenge);
  return (
    <div className="flex justify-center items-center h-[80vh]">
        <div className="flex flex-col items-center">
          <div className="flex gap-14">
            <Link to='/redirect' className='bg-blue-500 bg-opacity-100 text-white font-semibold py-2 px-4 border border-blue-500 rounded'>Login</Link>
          </div>
        </div>
      </div>
  )
}

export default Login