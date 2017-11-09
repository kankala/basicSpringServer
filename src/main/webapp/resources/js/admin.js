$(document).ready(function(){
	$( ".draggable" ).draggable();
	
	$( '.t_notice' ).find( 'tbody' ).on( 'click', 'tr' , function () {
		/*if($(this).hasClass('t_click') == true){
			$(this).closest('tbody').find('tr').removeClass( 't_click' );
		}else{*/
			$(this).closest('tbody').find('tr').removeClass( 't_click' );
			//$( '.table-hover1' ).find( 'li' ).removeClass( 't_click' );
			$( this ).addClass( 't_click' );
		//}
		
		/*$( '.table-hover1' ).find( 'tbody' ).find( 'tr' ).removeClass( 't_click' );
		
		$( this ).addClass( 't_click' );*/
		
		
	});
	
	$( '.table-hover1' ).on( 'click', 'li' , function () {
		if($(this).hasClass('t_click') == true){
			$(this).closest('ul').find('li').removeClass( 't_click' );
		}else{
			$(this).closest('ul').find('li').removeClass( 't_click' );
			//$( '.table-hover1' ).find( 'li' ).removeClass( 't_click' );
			$( this ).addClass( 't_click' );
		}
		
		
		
		
		
	});
	
	$( '.list2' ).on( 'click', 'li.btn_li' , function () {
		//$( '#monitoringBox' ).find('li.btn_li').removeClass( 't_click' );
		//$( this ).addClass( 't_click' );
		/*if($(this).hasClass('t_click') == true){
			$(this).closest('ul').find('li').removeClass( 't_click' );
		}else{*/
			$(this).closest('ul').find('li').removeClass( 't_click' );
			//$( '.table-hover1' ).find( 'li' ).removeClass( 't_click' );
			$( this ).addClass( 't_click' );
		//}
	});
	
	

	$(".date").datepicker({
		dateFormat: 'yy-mm-dd',
		prevText: '이전 달',
		nextText: '다음 달',
		monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		dayNames: ['일','월','화','수','목','금','토'],
		dayNamesShort: ['일','월','화','수','목','금','토'],
		dayNamesMin: ['일','월','화','수','목','금','토'],
		showMonthAfterYear: true,
		yearSuffix: '년'
	});
	
	var loading = false;
	
	

});
function rotation(e) {
    var times;
    if (e == true) {
        $("body").append(
        	"<div class='fullSize' style='position:fixed; top:0%; width:100%; height:100%; z-index:998; '>"+
                "<div class='fullBox2' style='position:absolute; left:50%; margin-left:-100px; top:50%; margin-top:-100px;'>"+ 
                    "<img src='/resources/image/loading.png' width=200 alt='' class='imgLo'>"+
                    "<img src='/resources/image/loadingText2.png'width=150 style='position:absolute; left:25px; top:30px; z-index:999;'alt=''class='imgTex'>"+
                    
                "</div>"+
            "</div>"
        
        );
        
        /*setTimeout(function() {
        
        },100);*/
        /*times = setInterval(function() {
        	$(".imgTex").css("display","block"); 
            $(".imgLo").css('display','block');
        	
        	$(".imgLo").rotate({
            angle:0,
            animateTo:720*10,
            callback: rotation,
            easing: function (x,t,b,c,d){        // t: current time, b: begInnIng value, c: change In value, d: duration
              return c*(t/d)+b;
                }
            });
       },100);*/
        
    } else if (e == false) {
        $(".fullSize").remove();
        /*clearInterval(times);
        $(".imgLo").rotate(0);
        $(".imgLo").css('display','none');
        $(".imgTex").css("display","none");*/
    }    
  
}
