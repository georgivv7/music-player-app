
function token() {
  const code_verifier = window.sessionStorage.getItem('codeVerifier');
  const code = sessionStorage.getItem('code');
  return (
   `http://localhost:8080/oauth2/token?client_id=clientapp&redirect_uri=http://localhost:3000/authorized&grant_type=authorization_code&code=${code}&code_verifier=${code_verifier}`
  )
}

export default token