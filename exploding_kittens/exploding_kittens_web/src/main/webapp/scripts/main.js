/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
            NopeCards = CM.MakeCards('Nope card', 18),
            ShuffleCards = CM.MakeCards('Shuffle card', 8),
            FavorCards = CM.MakeCards('Favor card', 8),
            SkipCards = CM.MakeCards('Skip card', 5),
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


