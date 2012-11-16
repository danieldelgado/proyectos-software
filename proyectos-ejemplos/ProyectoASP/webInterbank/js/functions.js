// JavaScript Document

/*Redondear bordes en IE*/
DD_roundies.addRule('.links', '0px 0px 20px 0px');
DD_roundies.addRule('.menu li', '10px 10px 0px 0px');
DD_roundies.addRule('.medio .form .trform', '10px 10px 0px 0px');
DD_roundies.addRule('.medio .form', '20px 0px 20px 0px');
DD_roundies.addRule('.menuemp li', '10px 10px 0px 0px');
DD_roundies.addRule('.medio .sideright .cabverde', '10px 10px 0px 0px');
/*DD_roundies.addRule('.paging li a', '5px');*/

$$('.sidebar .pago ').addEvent('mouseenter', function(){this.fade(0.8);	}) 
$$('.sidebar .pago ').addEvent('mouseleave', function(){this.fade(1);})  

$$('.sidebar .movil').addEvent('mouseenter', function(){this.getElement('a').fade(0.8);	}) 
$$('.sidebar .movil').addEvent('mouseleave', function(){this.getElement('a').fade(1);}) 
