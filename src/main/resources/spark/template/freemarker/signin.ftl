<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
  <meta http-equiv="refresh" content="10">
  <title>Web Checkers </title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<body>
<div class="page">

  <h1>Web Checkers </h1>


  <div class="body">

    <!-- Provide a message to the user, if supplied. -->
      <#include "message.ftl" />
    <form action="./signin" method="POST">
      <label for='name'>name:</label>
      <input name='name' placeholder='Enter a name...' />
      <button type='submit'>Sign in</button>
    </form>

  </div>

</div>
</body>

</html>