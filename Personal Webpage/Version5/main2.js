var new_light_color;
var new_light_color2;
var new_dark_color;
var new_dark_color2;
var colors = [[], []];  //2d arrary
var numofc = 1;
var numofcmax = 1;


// constructor homepage-controller
function setup() {

    setTimeout(loadingcompleted, 200); //js/main.js

    function loadingcompleted() {
        changebackground();
        savecolors();
        topbar();
        setuptopbar();
        setupsidenav();


        $("#title").click(function () {
            var cur = $(this).css('color');
            $(this).css({color: 'white'});
            changeallfromtitle();
        });

    }
}


function changeallfromtitle() {

    changebackground();

    numofc++;
    if (numofc == 11)
        numofc = 1; //start over

    savecolors();

    topbar();

    if (numofcmax < 10)
        numofcmax = numofc;
}


function changebackground() {
    var min = 70;
    var range = 70;
    new_light_color = 'rgb(' + (Math.floor((256 - 229) * Math.random()) + 220) + ',' + (Math.floor((256 - 229) * Math.random()) + 230) + ',' + (Math.floor((256 - 229) * Math.random()) + 230) + ')';
    new_light_color2 = 'rgb(' + (Math.floor((256 - 229) * Math.random()) + 230) + ',' + (Math.floor((256 - 229) * Math.random()) + 230) + ',' + (Math.floor((256 - 229) * Math.random()) + 230) + ')';
    new_dark_color = 'rgb(' + (Math.floor((range) * Math.random()) + min ) + ',' + (Math.floor((range) * Math.random()) + min - 30 ) + ',' + (Math.floor((range ) * Math.random()) + min - 70 ) + ')';
    new_dark_color2 = 'rgb(' + (Math.floor((range) * Math.random()) + min ) + ',' + (Math.floor((range) * Math.random()) + min - 30) + ',' + (Math.floor((range ) * Math.random()) + min - 70 ) + ')';
    // $("body").stop().animate({backgroundColor: new_light_color}, 1000);
    $("#about, #title, h1, .cd-date, h2").stop().animate({color: new_dark_color}, 1000);
    $("#sidenav, #bar").stop().css({background: new_dark_color}, 1000);
}


// set up top bar
function setuptopbar() {
    $('.row5 li').css({backgroundColor: 'yellow', visibility: 'hidden'});
    $('.row1 li, .row2 li, .row3 li, .row4 li').hover(function () {
        var a = $(this).index() + 1;
        if (a <= numofcmax) {
            $('.row5 li:nth-child(' + a + ')').css("visibility", 'visible');
        }
    }, function () {
        $('.row5 li').stop().css("visibility", 'hidden');

    });

    topbarclicks();

    function topbarclicks() {
        $('.row1 li, .row2 li, .row3 li, .row4 li').click(function () {
            var a = $(this).index() + 1;

            if (a <= numofcmax) {
                topbar2(a);
                var c1 = colors[a][0]; //new dark
                var c2 = colors[a][1]; //new light
                var c3 = colors[a][2]; //pre light
                var c4 = colors[a][3]; //new dark 2

                changeallfromtopbar(c1, c2, c3, c4);
            }
        });

        function topbar2(n) {
            var c1 = colors[n][0];
            var c2 = colors[n][1];
            var c3 = colors[n][2];
            var c4 = colors[n][3];
            $('.row1 li:nth-child(' + (n) + '), .row2 li:nth-child(' + (n) + '), .row3 li:nth-child(' + (n) + '),.row4 li:nth-child(' + (n) + ')').stop().css("background-color", 'white');
            $('.row1 li:nth-child(' + (n) + ')').animate({"background-color": c1}, 'slow');
            $('.row2 li:nth-child(' + (n) + ')').animate({"background-color": c2}, 'slow');
            $('.row3 li:nth-child(' + (n) + ')').animate({"background-color": c3}, 'slow');
            $('.row4 li:nth-child(' + (n) + ')').animate({"background-color": c4}, 'slow');
        }

        function changeallfromtopbar(c1, c2, c3, c4) {
            // $("body").stop().animate({backgroundColor: c2}, 1000);
            $("#title, h1, h2").stop().css({color: c1}, 1500);
            $("#sidenav, #bar").stop().css({background: c1}, 1000);
            $(".block").stop().css({color: c4}, 500);
        }
    }
}

function savecolors() {
    colors[numofc] = [];
    colors[numofc][0] = new_dark_color;
    colors[numofc][1] = new_light_color;
    colors[numofc][2] = new_light_color2;
    colors[numofc][3] = new_dark_color2;
}


// top bar blinks(White) then changes to the generated color
function topbar() {
    $('.row1 li:nth-child(' + (numofc) + '), .row2 li:nth-child(' + (numofc) + '), .row3 li:nth-child(' + (numofc) + '),.row4 li:nth-child(' + (numofc) + ')').stop().css("background-color", 'white');
    $('.row1 li:nth-child(' + (numofc) + ')').animate({"background-color": colors[numofc][0]}, 'slow');
    $('.row2 li:nth-child(' + (numofc) + ')').animate({"background-color": colors[numofc][1]}, 'slow');
    $('.row3 li:nth-child(' + (numofc) + ')').animate({"background-color": colors[numofc][2]}, 'slow');
    $('.row4 li:nth-child(' + (numofc) + ')').animate({"background-color": colors[numofc][3]}, 'slow');
}



// the entry animation for each page
function startanimation() {
    recursiveshow(1);

    function recursiveshow(n) {
        color = 'rgb(' + (Math.floor((256 - 229) * Math.random()) + 220) + ',' + (Math.floor((256 - 229) * Math.random()) + 220) + ',' + (Math.floor((256 - 229) * Math.random()) + 220) + ')';
        $('.block:nth-child(' + n + ')').css({background: color}).animate({width: '100%'}, 300);
        if (n < 10)
            setTimeout(function () {
                recursiveshow(++n);
            }, 100);
        else
            setTimeout(function () {
                recursivehide(10);
            }, 100);
    }

    function recursivehide(n) {
        $('.block:nth-child(' + n + ')').animate({height: '9%'}, 255);
        if (n > 0)
            setTimeout(function () {
                recursivehide(--n);
            }, 155);
    }
}


// sidenav
function openNav() {
    document.getElementById("sidenav").style.width = "150px";
    $(".main").css({marginLeft: "150px"});
}

function closeNav() {
    document.getElementById("sidenav").style.width = "28px";
    $(".main").css({marginLeft: "0"});
}

function setupsidenav() {
    $(".sidenav").hover(function () {
            $(this).css({background: new_dark_color2})
        }, function () {
            $(this).css({background: 'transparent'})
        }
    );
}



