 <div class="navigation">
  <#if userSignedIn??>
    <a href="/">my home</a>
    Your name is ${user}
    <a href="./signout">Sign Out</a>
  <#else>
    <a href="/signin">sign in</a>
  </#if>
 </div>
