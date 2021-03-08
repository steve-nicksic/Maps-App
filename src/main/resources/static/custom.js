var map;
var coords = {lat: 32.5252, lng: -93.7502};
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: coords, // this can be specific coordinates or setup with variable as we have it here
        zoom: 10
        scrollwheel: false
    });

    var marker = new google.maps.Marker({
    position: coords,
    map: map,
    icon: image,
    animation: google.maps.Animation.Bounce
    });

    var image = {url: '/enterprise1.png',
        scaledSize: new google.maps.Size(50, 50)};

    var contentString = '<h2>Shreveport, LA</h2> <p>Where your dreams come true.</p>';

     var infowindow = new google.maps.InfoWindow({
       content: contentString
     });

     google.maps.event.addListener(marker, 'click', function() {
        infowindow.open(map,marker);
     });
}