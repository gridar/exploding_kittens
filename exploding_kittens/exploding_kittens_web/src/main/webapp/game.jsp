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
        
        <h1>Exploding Kittens</h1>
        
            <% Player p = (Player)request.getSession().getAttribute("player");
               Engine game = (Engine)request.getSession().getAttribute("gameEngine");
               Player currentP = game.currentPlayer;
            %>
            
            
            <div class="pileContainer" id='pileContainer'>
                <h3><%= currentP.name %></h3>
            <br/>
            <% for(int i = 0; i < p.cards.size(); i++){%>
                <div class='<%=p.cards.get(i).getName()+"Pile "+p.cards.get(i).getName()+"Pile"+currentP.name%>'><%=p.cards.get(i).getName()%></div>
            <%}%>
            
            
                
            <div class="playarea" id='playarea'></div>
            <h2>Zone de jeux</h2>
            <% for(int i=0; i< game.players.size();i++){
                    if(!game.players.get(i).name.equals(currentP.name)){                        
            %>
                        <h3><%= game.players.get(i).name %></h3>
                        <br/>
                        <% for(int j = 0; j < game.players.get(i).cards.size(); j++){%>
                            <div class='<%=game.players.get(i).cards.get(j).getName()+"Pile "+game.players.get(i).cards.get(j).getName()+"Pile"+game.players.get(i).name%>'><%=game.players.get(i).cards.get(j).getName()%></div>
                        <%}
                    }                
                }                
            %>
        <div class="playarea" id='discardarea'></div>
        <h2>Zone de défausse</h2>
        <div id="CardsOfSeeTheFuture">
            
        </div>
        <h2>Deck</h2>
        <div class="bugPile" id="bugPile"></div>        
        
        </div> 
        <div>
            <form id="goServlet" name="goServlet"  method="post"  action="" >
                <input type="button" id="takecards" value="End the turn">                
            </form>
            <input type="button" id="resetcards" value="reset cards">
        </div>    
        
            
       
    </body>
    <script>
        
(function () {
  
  var RT = {
    
    CardManager: {
      
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
            var tmp = $(ui.draggable).attr("class").toString();
            var res = tmp.split(" ");
            if(res[0]==="See_the_future"){
                var element = document.getElementById("CardsOfSeeTheFuture");
                var para = document.createElement("h2");
                var node = document.createTextNode("See the future");
                para.appendChild(node);
                element.appendChild(para);
                
                var para0 = document.createElement("div");
                var node0 = document.createTextNode("<%=game.deck.cards.get(0).getName()%>");
                para0.className="<%=game.deck.cards.get(0).getName()%>"+" card";
                para0.appendChild(node0);
                element.appendChild(para0);
                
                var para1 = document.createElement("div");
                var node1 = document.createTextNode("<%=game.deck.cards.get(1).getName()%>");
                para1.className="<%=game.deck.cards.get(1).getName()%>"+" card";
                para1.appendChild(node1);
                element.appendChild(para1);
                
                var para2 = document.createElement("div");
                var node2 = document.createTextNode("<%=game.deck.cards.get(2).getName()%>");
                para2.className="<%=game.deck.cards.get(2).getName()%>"+" card";
                para2.appendChild(node2);
                element.appendChild(para2);
                
                
                
            }
            $(this).append(ui.draggable.css('left','').css('top',''));
            ui.draggable.draggable('destroy');
          }
        });
        
        <% for(int i=0; i< game.players.size();i++){  
            %>
            RT.CardManager.AddCards("<%=game.players.get(i).name%>");
        <%}%>
      },
      AddCards: function(player) {
        var CM = RT.CardManager,
            NopeCards = CM.MakeCards('Nope card '+player, 1),
            BugCards = CM.MakeCards('bug card ', <%=game.deck.cards.size()%>), 
            ShuffleCards = CM.MakeCards('Shuffle card '+player, 1),
            FavorCards = CM.MakeCards('Favor card '+player, 1),
            SkipCards = CM.MakeCards('Skip card '+player, 1),
            KittenCards = CM.MakeCards('Kitten card '+player, 1),
            AttackCards = CM.MakeCards('Attack card '+player, 1),
            See_the_futureCards = CM.MakeCards('See_the_future card '+player, 1),
            Exploding_kittenCards = CM.MakeCards('Exploding_kitten card '+player, 1),
            DefuseCards = CM.MakeCards('Defuse card '+player, 1);
        
        $('.NopePile'+player).append(NopeCards);
        $('.bugPile').append(BugCards);
        $('.ShufflePile'+player).append(ShuffleCards);
        $('.FavorPile'+player).append(FavorCards);
        $('.SkipPile'+player).append(SkipCards);
        $('.KittenPile'+player).append(KittenCards);
        $('.AttackPile'+player).append(AttackCards);
        $('.See_the_futurePile'+player).append(See_the_futureCards);
        $('.Exploding_kittenPile'+player).append(Exploding_kittenCards);
        $('.DefusePile'+player).append(DefuseCards);

        $('.card').draggable({ containment: "#pileContainer" , scroll: false });
        $('.playarea .card').draggable('destroy');
        $('.bug').draggable('destroy');
        
      }
    }
  };
  RT.CardManager.init();
  
   $('#takecards').on('click', function () {
       console.log("enculeeeeeeee");
       var Playarea = document.getElementById("playarea" ).childNodes;
       var i;
       var result = [];
       var resultArgs = [];
       var tmp;
       var size=  Playarea.length;
       var args = "?SizeCards="+size;
       for(i =0; i <size;i++){
           result.push(Playarea[i].className);
           tmp = Playarea[i].className.toString().split(" ");
           args+="&c"+i.toString()+"="+tmp[0]+"-"+tmp[2];
       }
       
       var element = document.getElementById("goServlet");
       element.setAttribute("action", "test"+args);
       $('#goServlet').submit();
  });
   $('#resetcards').on('click', function () {
       location.reload();
  });
  
})();
    </script>
</html>
