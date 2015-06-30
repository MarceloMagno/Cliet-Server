<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
 
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cliente Web Server</title>
        <link rel="stylesheet" href="resources/css/sistema.css">
    <style>
      #login{
          box-shadow: 0 0 2px rgba(0, 0, 0, 0.2), 0 1px 1px rgba(0, 0, 0, .2), 0 3px 0 #fff, 0 4px 0 rgba(0, 0, 0, .2), 0 6px 0 #fff, 0 7px 0 rgba(0, 0, 0, .2);
      }
      
      #login{
            position: relative;
            z-index: 0;
        }

      #login:before{
          content: '';
          position: absolute;
          z-index: -1;
          border: 1px dashed #ccc;
          top: 5px;
          bottom: 5px;
          left: 5px;
          right: 5px;
          -moz-box-shadow: 0 0 0 1px #fff;
          -webkit-box-shadow: 0 0 0 1px #fff;
          box-shadow: 0 0 0 1px #fff;
      }
      
      h1{
        text-shadow: 0 1px 0 rgba(255, 255, 255, .7), 0px 2px 0 rgba(107,35,142, .5);
        text-transform: uppercase;
        text-align: center;
        color: #E0E0E0;
        margin: 0 0 30px 0;
        letter-spacing: 4px;
        font: normal 28px/2 Verdana, Helvetica;
        position: relative;
    }
    
    h1:after, h1:before{
        background-color: #777;
        content: "";
        height: 1px;
        position: absolute;
        top: 15px;
        width: 120px;   
    }
    
    h1:after{ 
        background-image: -webkit-gradient(linear, left top, right top, from(#777), to(#fff));
        background-image: -webkit-linear-gradient(left, #777, #fff);
        background-image: -moz-linear-gradient(left, #777, #fff);
        background-image: -ms-linear-gradient(left, #777, #fff);
        background-image: -o-linear-gradient(left, #777, #fff);
        background-image: linear-gradient(left, #777, #fff);      
        right: 0;
    }
    
    h1:before{
        background-image: -webkit-gradient(linear, right top, left top, from(#777), to(#fff));
        background-image: -webkit-linear-gradient(right, #777, #fff);
        background-image: -moz-linear-gradient(right, #777, #fff);
        background-image: -ms-linear-gradient(right, #777, #fff);
        background-image: -o-linear-gradient(right, #777, #fff);
        background-image: linear-gradient(right, #777, #fff);
        left: 0;
    }
    
    /* --- h2 -- */
    h2{
        text-shadow: 0 1px 0 rgba(255, 255, 255, .7), 0px 2px 0 rgba(0, 0, 0, .5);
        text-transform: uppercase;
        text-align: center;
        color: #666;
        margin: 0 0 30px 0;
        letter-spacing: 4px;
        font: normal 26px/1 Verdana, Helvetica;
        position: relative;
    }
    
    h2:after, h2:before{
        background-color: #777;
        content: "";
        height: 1px;
        position: absolute;
        top: 15px;
        width: 120px;   
    }
    
    h2:after{ 
        background-image: -webkit-gradient(linear, left top, right top, from(#777), to(#fff));
        background-image: -webkit-linear-gradient(left, #777, #fff);
        background-image: -moz-linear-gradient(left, #777, #fff);
        background-image: -ms-linear-gradient(left, #777, #fff);
        background-image: -o-linear-gradient(left, #777, #fff);
        background-image: linear-gradient(left, #777, #fff);      
        right: 0;
    }
    
    h2:before{
        background-image: -webkit-gradient(linear, right top, left top, from(#777), to(#fff));
        background-image: -webkit-linear-gradient(right, #777, #fff);
        background-image: -moz-linear-gradient(right, #777, #fff);
        background-image: -ms-linear-gradient(right, #777, #fff);
        background-image: -o-linear-gradient(right, #777, #fff);
        background-image: linear-gradient(right, #777, #fff);
        left: 0;
    }
    
    </style>
        
    </head>
    <body class="login">
    
    <div class="topo">
        <h1>Client Web Server</h1>
    </div>
  
  <table align="center" style="margin-top: 20px;" class="corLogin" >
    <tr>
        <td>
          <div style="text-align: center;  margin-bottom: 30px;">
              <div style="text-align: center;"><img src="resources/images/logo-coca.png" alt="Coca-Cola"></div>
          </div>
        </td>
      </tr>
    <tr>
      <td>
       <form id="login" action="j_spring_security_check" method="post">
          <h2>LOGIN</h2>          
          <fieldset id="inputs">
              <input id="username" type="text" name="j_username" placeholder="Usuário" autofocus required>   
              <input id="password" type="password" name="j_password" placeholder="Senha" required>
          </fieldset>
          <fieldset id="actions">
              <input type="submit" onclick="getErro()" id="submit" value="Efetuar Login">
              <!-- <a href="">Esqueceu sua senha?</a><a href="">Cadastrar</a> -->
          </fieldset>
          
          <fieldset>
              <%
            if(request.getParameter("error") != null){
              if (request.getParameter("error").equals("error")){
          %>
          <p style="text-align: center;"> <span style="color:red; ">Usuário ou Senha Inválido</span></p>
          <%
              }
            }
          %>
          </fieldset>
      </form>
      
        </td>        
        </tr>
  </table>
  </body>
</html>