$('.accordion').on('click', '.accordion-control', function(e){ //when clicked
e.preventDefault();         // Prevent the default action of button
$(this)                     // Get the element the user clicked on
.next('.accordion-panel')   // select the following panel
.not(':animated')           // if it is not currently animated
.slideToggle();             // use slide toggle to show or hide it
});