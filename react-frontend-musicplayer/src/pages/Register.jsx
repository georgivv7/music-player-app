import React, { useState } from 'react';
import { useNavigate } from 'react-router';
import '../registerFormStying.css';
  
function Register() {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        username: '',
        password: '',
    });

    const [usernameError, setUsernameError] = useState(null);
    const [passwordError, setPasswordError] = useState(null);

    //const csrfToken = document.cookie.match(/XSRF-TOKEN=([^;]+)/)[1];

const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(({ ...formData, [name]: value }));

    setUsernameError(validateUsername());
    setPasswordError(validatePassword());
};

const validateUsername = () => {
    const { username } = formData;
    if (username.length < 6) {
      return 'Username must be at least 6 characters long.';
    }
    if (!username.match(/^[a-zA-Z0-9]+$/)) {
      return 'Username can only contain alphanumeric characters.';
    }
    return null;
  };
  
  const validatePassword = () => {
    const { password } = formData;
    if (password.length < 8) {
      return 'Password must be at least 8 characters long.';
    }
    if (!password.match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).+$/)) {
      return 'Password must contain at least one lowercase letter, one uppercase letter, and one number.';
    }
    return null;
  };

const handleSubmit = async (e) => {
    e.preventDefault();

    const usernameError = validateUsername();
    const passwordError = validatePassword();

    if (usernameError || passwordError) {
        alert('Please check your input fields.');
        return;
      }

    const url = 'http://localhost:9000/register';
    const headers = new Headers();
    headers.append('Content-type', 'application/json');
    //headers.append('X-XSRF-TOKEN', csrfToken);

    try {
        const response = await fetch(url, {
            credentials: 'include',
            method: 'POST',
            mode: 'cors',
            body: JSON.stringify(formData),
            headers: headers,
            withCredentials: true
        });

        if (response.ok) {
            alert('Registration successful');
        } else {
            alert('Registration failed');
        }

        navigate('/login');

    } catch (err) {
        console.log(err);
    }   
};


    return (
      <div className="flex flex-col items-center">
            <h2 className="text-3xl mb-8 mt-10">Registration</h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-4"> 
                    <label htmlFor="username">Username:</label>
                    <input
                        type="text"
                        id="username"
                        name="username"
                        value={formData.username}
                        onChange={handleChange}
                        required
                    />
                    {usernameError && <p style={{ color: 'red' }}>{usernameError}</p>}
                </div>
                <div className="mb-4">
                    <label htmlFor="password">Password:</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                    {passwordError && <p style={{ color: 'red' }}>{passwordError}</p>}
                </div>
                <button className='bg-blue-500 bg-opacity-100 text-white font-semibold py-2 px-4 border border-blue-500 rounded' type="submit">Register</button>
                
            </form>  
            {/* <button className="btn btn-primary" type="button" onClick={() => navigate('/login')}>Login</button> */}
        </div>
    )
}

export default Register;

