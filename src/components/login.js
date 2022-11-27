import React, { useState } from 'react'
import '../loginpage.css'
/*
  This component renders the Login Form with all its functionalities
  startLogin is the method that uses the axios service to submit login credentials to the backend
*/
const LoginForm = ({ startLogin }) => {
  // States for tracking form input which are the email address and password
  const [ email, setEmail ] = useState('')
  const [ password, setPassword ] = useState('')

  // onSubmit event handler of this form
  const handleLogin = (event) => {
    // Preventing default submission of the form to the action attribute URL
    event.preventDefault()

    const credentials = {
      email, password
    }

    // Calling startLogin with the provided credentials that will make a call to the backend
    startLogin(credentials)

    // Reset the form state, i.e. the text that's on the username and password text boxes to empty strings
    setEmail('')
    setPassword('')
  }

  // Typically keep id attributes on your HTML elements so that they can be styled using CSS
  return (
    
    <>
      <div id="Box">
            <div id="adminLogin_backgroundImg"></div>
                <section id="adminLogin" className="adminLogin"> 
                    <div className="adminLogin-head">
                        <h1>Administrator Login</h1> 
                            <form id="adminLogin-form">
                                <p>
                                   
									<input type="text" id="adminLogin-email" name="email" placeholder="Email ID " 
                                      value={email}
                                      onChange={event => setEmail(event.target.value)}
                                    title="Please enter Email Id " required/>
									
                                </p>
                                <p>
                                   
									<input type="password" id="adminLogin-password" name="password" placeholder="Password" 
                                    value={password}
                                    onChange={event => setPassword(event.target.value)}
                                    title="Please enter Password"  required/>
                                   
                                </p>
                                <p>
                                    <input type="submit" id="adminLogin-login" value="Login" onSubmit={handleLogin} /> 
                                </p>
                            </form>
                    </div>
                </section>
                </div>
                </>
        

  )

  
}

export default LoginForm


        