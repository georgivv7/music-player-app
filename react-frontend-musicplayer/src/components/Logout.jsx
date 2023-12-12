import React from 'react'
import { useDispatch } from 'react-redux';
import { logout } from '../redux/features/authSlice';

const Logout = () => {

    const dispatch = useDispatch();
    const handleLogout = async () => {
        try {
          const response = await fetch('http://localhost:8080/logout', {
            method: 'POST'
          });
      
          if (response.status === 200) {
            dispatch(logout());
            window.sessionStorage.clear();
            window.location.href = 'http://localhost:8080/logout';
          }
        } catch (err) {
          console.error('Logout failed', err);
        }
      };

    return (
        <div className="flex justify-center items-center h-[80vh]">
          <div className="flex flex-col items-center">
            <h1 className="text-4xl text-white font-bold mb-8">Logging out</h1>
            <div className="flex gap-14">
              <button
                onClick={handleLogout}
                className='bg-red-500 bg-opacity-100 text-white font-semibold py-2 px-4 border border-red-500 rounded'
              >
                Logout
              </button>
            </div>
          </div>
        </div>
      );
}

export default Logout