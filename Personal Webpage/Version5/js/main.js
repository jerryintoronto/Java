// globla variables

var new_light_color;
var new_light_color2;
var new_dark_color;
var new_dark_color2;
var colors = [[], []];  //2d arrary
var numofc = 1;
var numofcmax = 1;
var scrolls = 1;
var activepage2 = true;


function loadingcompleted() {
    setupintialcolors();
    setupmainpage();
    generalhovereffects();
    setuptopbar();
    topbarclicks();
    setupscroll();
}


//                  -------------------
//                  initial colors
//                  -------------------
function setupintialcolors() {
    //color on first load is consistent
    new_light_color = "rgb(248,250,251)";
    new_light_color2 = "rgb(232,236,253)";
    new_dark_color = "rgb(134,49,41)";
    new_dark_color2 = "rgb(97,82,55)";
    animateforeground();
    animatebackground();
    savecolors();
    topbar();
}


//                  -------------------
//                  Hover Effects!
//                  -------------------

function generalhovereffects() {
    //clicking on my name
    $("#title").click(function () {
        var cur = $(this).css('color');
        $(this).css({color: 'white'});
        changeallscrolling();
        animatetimeline()
    });

    $(".cd-date").hover(function () {
        $(this).animate({fontSize: 23});
    }, function () {
        $(this).animate({fontSize: 20});
    });
}


function setupmainpage() {
    $("#main").fadeIn();
    createHighChart(new_light_color2, new_dark_color, new_light_color, new_dark_color2);
    animatetimeline();
}

function changebackground() {
    new_light_color = 'rgb(' + (Math.floor((256 - 229) * Math.random()) + 230) + ',' + (Math.floor((256 - 229) * Math.random()) + 230) + ',' + (Math.floor((256 - 229) * Math.random()) + 230) + ')';
    new_light_color2 = 'rgb(' + (Math.floor((256 - 229) * Math.random()) + 230) + ',' + (Math.floor((256 - 229) * Math.random()) + 230) + ',' + (Math.floor((256 - 229) * Math.random()) + 230) + ')';
    animatebackground(new_light_color, new_light_color2);
}

function animatebackground() {
    $("body").animate({backgroundColor: new_light_color}, 1000);
    $(".cd-timeline-content").animate({backgroundColor: new_light_color2}, 1500);
}

function changeforegroundcolor() {
    var min = 70;
    var range = 70;
    new_dark_color = 'rgb(' + (Math.floor((range) * Math.random()) + min ) + ',' + (Math.floor((range) * Math.random()) + min - 30 ) + ',' + (Math.floor((range ) * Math.random()) + min - 70 ) + ')';
    new_dark_color2 = 'rgb(' + (Math.floor((range) * Math.random()) + min ) + ',' + (Math.floor((range) * Math.random()) + min - 30) + ',' + (Math.floor((range ) * Math.random()) + min - 70 ) + ')';
    animateforeground();
}

function animateforeground() {
    $("#about, #title, .cd-date, h2").stop().css('color', 'white').animate({color: new_dark_color}, 1000);
    $(".cd-picture, #footer").stop().css({background: new_dark_color}, 1000);
    $(".cd-location").stop().css({background: new_dark_color2}, 1000);
    $(".link, .timeline-text").stop().css('color', 'white').animate({color: new_dark_color2}, 1000);
}


//                  -----------
//                  top bar
//                   ------------

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
}

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
}

function savecolors() {
    colors[numofc] = [];
    colors[numofc][0] = new_dark_color;
    colors[numofc][1] = new_light_color;
    colors[numofc][2] = new_light_color2;
    colors[numofc][3] = new_dark_color2;
}


function topbar() {
    $('.row1 li:nth-child(' + (numofc) + '), .row2 li:nth-child(' + (numofc) + '), .row3 li:nth-child(' + (numofc) + '),.row4 li:nth-child(' + (numofc) + ')').stop().css("background-color", 'white');

    $('.row1 li:nth-child(' + (numofc) + ')').animate({"background-color": colors[numofc][0]}, 'slow');
    $('.row2 li:nth-child(' + (numofc) + ')').animate({"background-color": colors[numofc][1]}, 'slow');
    $('.row3 li:nth-child(' + (numofc) + ')').animate({"background-color": colors[numofc][2]}, 'slow');
    $('.row4 li:nth-child(' + (numofc) + ')').animate({"background-color": colors[numofc][3]}, 'slow');
}

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
    animatetimeline()

    //2nd trigger from clicking top bar
    $("body").stop().animate({backgroundColor: c2}, 1000);
    $(".cd-timeline-content").stop().animate({backgroundColor: c3}, 1500);
    $("#about, #title, .cd-date, h2").stop().css({color: c1}, 1500);
    $(".cd-picture, #footer").stop().css({background: c1}, 1000);
    $(".cd-location").stop().css({background: c4}, 1000);
    $(".link, .timeline-text").stop().css({color: c4}, 500);
    setTimeout(createHighChart(c3, c1, c2, c4), 500);
}


function changeallscrolling() {
//                        this is triggered through scrolling

    changebackground();
    changeforegroundcolor();

    numofc++;
    if (numofc == 11)
        numofc = 1; //start over

    savecolors();
    topbar();

    if (numofcmax < 10)
        numofcmax = numofc;

    setTimeout(createHighChart(new_light_color2, new_dark_color, new_light_color, new_dark_color2), 500);

}


// page2 animation

function setupscroll() {

    $(document).scroll(function () {
        scrolls += 1;
        if (scrolls % 120 == 0) {
            // changeallscrolling();
        }
    });

    if (activepage2) {
        //scroll to end
        $(window).scroll(function () {
            if ($(window).scrollTop() + $(window).height() > $(document).height() - 250) {
                scrolledtoend();
            }
        });
    }
}

function scrolledtoend() {
    if (activepage2) {
        activepage2 = false;
        $('#main').css({display: 'none'});
        $('#page2').css({display: 'show'});
        setTimeout(startanimation, 0);
    }
}

function startanimation() {
    recursiveshow(1);
}
function recursiveshow(n) {
    color = 'rgb(' + (Math.floor((256 - 229) * Math.random()) + 220) + ',' + (Math.floor((256 - 229) * Math.random()) + 220) + ',' + (Math.floor((256 - 229) * Math.random()) + 220) + ')';
    $('.block:nth-child(' + n + ')').css({background: color}).animate({width: '100%'}, 300);
    if (n < 10)
        setTimeout(function () { recursiveshow(++n); }, 100 );
    else
        setTimeout(function () { recursivehide(10); }, 100 );
}

function recursivehide(n) {
    $('.block:nth-child(' + n + ')').animate({height: '2%'}, 255);
    if (n > 0)
        setTimeout(function () { recursivehide(--n); }, 155);
    else
        setTimeout(showsecret, 155);
}

function showsecret() {

    // animated text
    $("#typed").typed({
        stringsElement: $('#typed-strings'),
        typeSpeed: 20,
        backDelay: 500,
        loop: true,
        contentType: 'html', // or text
        loopCount: false
    });
    $('.secret').fadeIn();

    //return to main page button
    $('.return').hover(function () {
        $('#page2, #scrolldown').stop().css({display: 'none'});
        $('#backtop, #main').fadeIn();
    });
}

//                  ---------------
//                  graph
//                  ---------------

function createHighChart(c3, c1, c2, c4) {

    Highcharts.chart('container', {
        chart: { type: 'column', backgroundColor: c3 },
        tooltip: {enabled: false},
        xAxis: { categories: ['HTML/CSS', 'jQuery', 'Angular.JS'] },
        plotOptions: {
            column: { stacking: 'normal' },
            series: { stats: { hover: { enabled: false } } }
        },
        series: [{
            name: 'Potential',
            data: [3, 3, 7],
            stack: 'a',
            color: c1
        }, {
            name: 'Current',
            data: [7, 7, 3],
            stack: 'a',
            color: c2
        }, {
            name: 'Interest',
            data: [10, 10, 10],
            stack: 'b',
            color: c4
        }]
    })
}


function animatetimeline() {
    var timelineBlocks = $('.cd-timeline-block'), offset = 0.6;
    hideBlocks(timelineBlocks, offset);
    $(window).on('scroll', function () {
        (!window.requestAnimationFrame) ? setTimeout(function () {
                showBlocks(timelineBlocks, offset);
        }, 100) : window.requestAnimationFrame(function () { showBlocks(timelineBlocks, offset); });
    });

    function hideBlocks(blocks, offset) {
        $(blocks).find('.cd-timeline-img, .cd-timeline-content').addClass('is-hidden').removeClass('bounce-in');
    }

    function showBlocks(blocks, offset) {
        blocks.each(function () {
            ( $(this).offset().top <= $(window).scrollTop() + $(window).height() * offset && $(this).find('.cd-timeline-img').hasClass('is-hidden') ) && $(this).find('.cd-timeline-img, .cd-timeline-content').removeClass('is-hidden').addClass('bounce-in');
        });
    }
}
