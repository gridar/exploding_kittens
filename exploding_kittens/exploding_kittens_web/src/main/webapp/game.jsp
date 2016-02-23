<%-- 
    Document   : game
    Created on : 11 févr. 2016, 13:30:56
    Author     : Nicolas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.mycompany.exploding_kittens_core.Model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js" type="text/javascript"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.0/html2canvas.min.js" type="text/javascript"></script>
        <link rel="stylesheet prefetch" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>TITI</h1>
        <h1>
            <% Player p = (Player)request.getSession().getAttribute("player");
               Engine game = (Engine)request.getSession().getAttribute("gameEngine");
               Player currentP = game.currentPlayer;
            %>
            
            
            <div class="pileContainer">
            <%= currentP.name %>
            <br/>
            <% for(int i = 0; i < p.cards.size(); i++){%>
                <div class='<%=p.cards.get(i).getName()+"Pile"%>'></div>
            <%}%>
            <div class="playarea"></div>
            <% for(int i=0; i< game.players.size();i++){
                    if(!game.players.get(i).name.equals(currentP.name)){                        
            %>
                        <%= game.players.get(i).name %>
                        <br/>
                        <% for(int j = 0; j < game.players.get(i).cards.size(); j++){%>
                            <div class='<%=game.players.get(i).cards.get(j).getName()+"Pile"%>'></div>
                        <%}
                    }                
                }                
            %>
        </div> 
            
        </h1>
            
       
    </body>
    <script>
        
(function () {

  var RT = {
    
    CardManager: {
      $NopePile: $('.NopePile'),
      $ShufflePile: $('.ShufflePile'),
      $FavorPile: $('.FavorPile'),
      $SkipPile: $('.SkipPile'),
      $KittenPile: $('.KittenPile'),
      $AttackPile: $('.AttackPile'),
      $See_the_futurePile: $('.See_the_futurePile'),
      $Exploding_kittenPile: $('.Exploding_kittenPile'),
      $DefusePile: $('.DefusePile'),
      $playarea: $('.playarea'),

      MakeCards: function(type, quantity) {
        var i, result = [];
        for (i = 0; i < quantity; i++) {
          result[i] = $("<div />", {
            class: type
          });
        }
        return result;
      },

      init: function() {
        RT.CardManager.$playarea.droppable({
          accept: '.card',
          activeClass: "ui-state-highlight",
          drop: function(event, ui) {
            $(this).append(ui.draggable.css('left','').css('top',''));
            ui.draggable.draggable('destroy');
          }
        });
        RT.CardManager.AddCards();
      },
      AddCards: function() {
        var CM = RT.CardManager,
            NopeCards = CM.MakeCards('Nope card', 1),
            ShuffleCards = CM.MakeCards('Shuffle card', 1),
            FavorCards = CM.MakeCards('Favor card', 1),
            SkipCards = CM.MakeCards('Skip card', 1),
            KittenCards = CM.MakeCards('Kitten card', 1),
            AttackCards = CM.MakeCards('Attack card', 1),
            See_the_futureCards = CM.MakeCards('See_the_future card', 1),
            Exploding_kittenCards = CM.MakeCards('Exploding_kitten card', 1),
            DefuseCards = CM.MakeCards('Defuse card', 1)

        CM.$NopePile.append(NopeCards);
        CM.$ShufflePile.append(ShuffleCards);
        CM.$FavorPile.append(FavorCards);
        CM.$SkipPile.append(SkipCards);
        CM.$KittenPile.append(KittenCards);
        CM.$AttackPile.append(AttackCards);
        CM.$See_the_futurePile.append(See_the_futureCards);
        CM.$Exploding_kittenPile.append(Exploding_kittenCards);
        CM.$DefusePile.append(DefuseCards);

        $('.card').draggable();
        $('.playarea .card').draggable('destroy');
        
      }
    }
  }
  RT.CardManager.init();

  
})();
    </script>
</html>
