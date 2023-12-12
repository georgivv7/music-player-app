import React from 'react'
import { Link } from 'react-router-dom';

function Home() {
  
  return (
        <div className="flex justify-center items-center h-[80vh]">
        <div className="flex flex-col items-center">
          <h1 className="text-4xl font-bold mb-8">Welcome to Lyriks!</h1>
          <div className="flex gap-14">
            <Link to='/login' className='bg-blue-500 bg-opacity-100 text-white font-semibold py-2 px-4 border border-blue-500 rounded'>Login</Link>
            <Link to='/register' className='bg-blue-500 bg-opacity-100 text-white font-semibold py-2 px-4 border border-blue-500 rounded'>Register</Link>
          </div>
        </div>
      </div>
    )
}

export default Home