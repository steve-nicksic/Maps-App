var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 32.5252, lng: -93.7502},
        zoom: 10
    });
}