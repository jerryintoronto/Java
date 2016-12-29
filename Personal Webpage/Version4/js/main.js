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
//                 ---------------------
//                 global variables
//                 -------------------------


    setupmainpage()

    function setupmainpage() {
        $("#main").fadeIn();
        animatetimeline()
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

//                  -------------------
//                  initial colors
//                  -------------------
    setupintialcolors()
    function setupintialcolors() {

        //rng can produce some awful color themes. I want to make sure the first one is decent.
        new_light_color = "rgb(248,250,251)";
        new_light_color2 = "rgb(232,236,253)";
        new_dark_color = "rgb(134,49,41)";
        new_dark_color2 = "rgb(97,82,55)";
        animateforeground();
        animatebackground();
        savecolors();
        topbar();
        createHighChart(new_light_color2, new_dark_color, new_light_color, new_dark_color2);
        // setTimeout(createHighChart(new_light_color2, new_dark_color, new_light_color, new_dark_color2), 500);
    }


//                  -------------------
//                  Hover Effects!
//                  -------------------
    generalhovereffects()
    function generalhovereffects() {


        //clicking on my name
        $("#title").click(function () {

            var cur = $(this).css('color');
            $(this).css({color: 'white'});
//                        $(this).css({color: cur}, 1000);

            changeallscrolling()
            animatetimeline()
        });


        $(".cd-date").hover(function () {
            $(this).animate({fontSize: 23});
        }, function () {
            $(this).animate({fontSize: 20});
        });
    }

//                  -----------
//                  top bar
//                   ------------
    setuptopbar();
    topbarclicks()
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
        $('.row1 li:nth-child(' + (numofc) + ')').stop().css("background-color", 'white');
        $('.row2 li:nth-child(' + (numofc) + ')').stop().css("background-color", 'white');
        $('.row3 li:nth-child(' + (numofc) + ')').stop().css("background-color", 'white');
        $('.row4 li:nth-child(' + (numofc) + ')').stop().css("background-color", 'white');

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

        $('.row1 li:nth-child(' + (n) + ')').stop().css("background-color", 'white');
        $('.row2 li:nth-child(' + (n) + ')').stop().css("background-color", 'white');
        $('.row3 li:nth-child(' + (n) + ')').stop().css("background-color", 'white');
        $('.row4 li:nth-child(' + (n) + ')').stop().css("background-color", 'white');

        $('.row1 li:nth-child(' + (n) + ')').animate({"background-color": c1}, 'slow');
        $('.row2 li:nth-child(' + (n) + ')').animate({"background-color": c2}, 'slow');
        $('.row3 li:nth-child(' + (n) + ')').animate({"background-color": c3}, 'slow');
        $('.row4 li:nth-child(' + (n) + ')').animate({"background-color": c4}, 'slow');
    }

    function changeallfromtopbar(c1, c2, c3, c4) {
        animatetimeline()

        //2nd trigger from clicking top bar
        $("body").animate({backgroundColor: c2}, 1000);
        $(".cd-timeline-content").animate({backgroundColor: c3}, 1500);
        $("#about, #title, .cd-date, h2").stop().css({color: c1}, 1500);
        $(".cd-picture, #footer").stop().css({background: c1}, 1000);
        $(".cd-location").stop().css({background: c4}, 1000);
        $(".link, .timeline-text").stop().css({color: c4}, 500);
        setTimeout(createHighChart(c3, c1, c2, c4), 500);
    }


//                  ----------------------
//                  scroll color changes
//                  ----------------------
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

    setupscroll()
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
            $('#page2').fadeIn();
            recursiveshow(1);
            setTimeout(function () {
                recursivehide(4);
            }, 100);
            setTimeout(showsecret, 1600);


            $("#typed").typed({
                stringsElement: $('#typed-strings'),
                typeSpeed: 20,
                backDelay: 500,
                loop: true,
                contentType: 'html', // or text
                loopCount: false,
            });


            //return to main page
            $('.return').hover(function () {

                $('#main').fadeIn();
                $('#page2').css({display: 'none'});
                $('#page2').stop();
                $('#backtop').fadeIn();
                $('#scrolldown').hide();

            });
        }

        function recursiveshow(n) {
            color = 'rgb(' + (Math.floor((256 - 229) * Math.random()) + 220) + ',' + (Math.floor((256 - 229) * Math.random()) + 200) + ',' + (Math.floor((256 - 229) * Math.random()) + 200) + ')';
            $('.block:nth-child(' + n + ')').css({background: color});
            $('.block:nth-child(' + n + ')').stop().animate({width: '100%'}, 700);
            n = n + 1;
            if (n <= 3)
                setTimeout(function () {
                        recursiveshow(n);
                    }, 55
                );
        }

        function recursivehide(n) {
            $('.block:nth-child(' + n + ')').stop().animate({height: '2%'}, 1000);
            n = n - 1;
            if (n >= 0)
                setTimeout(function () {
                    recursivehide(n);
                }, 155);
        }

        function showsecret() {
            $('.secret').css({height: '50%'});
            $('.secret').fadeIn();
        }


//             -----------   end ------------------------------------

    }
}


//                  ---------------
//                  graph
//                  ---------------

function createHighChart(c3, c1, c2, c4) {

    Highcharts.chart('container', {
        chart: {
            type: 'column',
            backgroundColor: c3
//                                new_light_color2
        },

        title: {
            text: 'My Skills Chart'
        },

        tooltip: {enabled: false},

        xAxis: {
            categories: ['HTML/CSS', 'jQuery', 'Angular.JS', 'React.JS']
        },

        plotOptions: {
            column: {
                stacking: 'normal'
            },
            series: {
                stats: {
                    hover: {
                        enabled: false
                    }
                }
            }

        },

        series: [{
            name: 'Hope to Learn',
            data: [4, 5, 7],
            stack: 'a',
            color: c1
//                        new_dark_color
        }, {
            name: 'Self Evaluation',
            data: [6, 5, 3],
            stack: 'a',
            color: c2
//                                new_light_color
        }, {
            name: 'Interest',
            data: [10, 10, 10],
            stack: 'b',
            color: c4
//                                new_dark_color2
        }]
    })
}


function animatetimeline() {
    var timelineBlocks = $('.cd-timeline-block'),
        offset = 0.6;

    //hide timeline blocks which are outside the viewport
    hideBlocks(timelineBlocks, offset);

    //on scolling, show/animate timeline blocks when enter the viewport
    $(window).on('scroll', function () {
        (!window.requestAnimationFrame)
            ? setTimeout(function () {
                showBlocks(timelineBlocks, offset);
            }, 100)
            : window.requestAnimationFrame(function () {
                showBlocks(timelineBlocks, offset);
            });
    });

    function hideBlocks(blocks, offset) {
        $(blocks).find('.cd-timeline-img, .cd-timeline-content').addClass('is-hidden').removeClass('bounce-in');
        // (function(){ ( $(this).offset().top > $(window).scrollTop()+$(window).height()*offset ) && $(this).find('.cd-timeline-img, .cd-timeline-content').addClass('is-hidden'); });
    }

    function showBlocks(blocks, offset) {
        blocks.each(function () {
            ( $(this).offset().top <= $(window).scrollTop() + $(window).height() * offset && $(this).find('.cd-timeline-img').hasClass('is-hidden') ) && $(this).find('.cd-timeline-img, .cd-timeline-content').removeClass('is-hidden').addClass('bounce-in');
        });
    }
}
