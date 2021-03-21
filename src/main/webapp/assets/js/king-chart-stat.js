$(document).ready(function () {

    function getRandomValues() {
        // data setup
        var values = new Array(20);

        for (var i = 0; i < values.length; i++) {
            values[i] = [5 + randomVal(), 10 + randomVal(), 15 + randomVal(), 20 + randomVal(), 30 + randomVal(),
                35 + randomVal(), 40 + randomVal(), 45 + randomVal(), 50 + randomVal()]
        }

        return values;
    }



    /* sparkline on window resize */
    var sparkResize;

    $(window).resize(function (e) {
        clearTimeout(sparkResize);

        if ($('.sparkline-stat-item .inlinesparkline').length > 0) {
            sparkResize = setTimeout(sparklineStat, 200);
        }

        if ($('.secondary-stat-item .inlinesparkline').length > 0) {
            sparkResize = setTimeout(sparklineWidget, 200);
        }
    });





    //*******************************************
    /*	CHART AND STAT DEMO PAGE
     /********************************************/

    if ($('#demo-line-chart').length > 0)
        chartYear($('#demo-line-chart'));
    if ($('#demo-area-chart').length > 0)
        chartWeek($('#demo-area-chart'));
    if ($('#demo-vertical-bar-chart').length > 0)
        chartBarVertical($('#demo-vertical-bar-chart'));
    if ($('#demo-horizontal-bar-chart').length > 0)
        chartBarHorizontal($('#demo-horizontal-bar-chart'));
    if ($('#demo-multi-types-chart').length > 0)
        chartMonth($('#demo-multi-types-chart'));

    /* interactive chart demo page */
    if ($('#demo-toggle-series-chart').length > 0) {
        chartToggleSeries($('#demo-toggle-series-chart'));
    }

    if ($('#demo-select-zoom-chart').length > 0) {
        chartSelectZoomSeries($('#demo-select-zoom-chart'));
    }

    /* real-time chart demo */
    if ($('#demo-real-time-chart').length > 0) {
        chartRealtTime($('#demo-real-time-chart'), "bar");
    }

    /* javascript helper functions */
    function showTooltip(x, y, contents) {

        $("<div id='tooltip' class='flot-tooltip'>" + contents + "</div>").css({
            top: y + 5,
            left: x + 5,
        }).appendTo("body").fadeIn(200);
    }

    // get day function
    function gt(y, m, d) {
        return new Date(y, m - 1, d).getTime();
    }

    function donutLabelFormatter(label, series) {
        return "<div class=\"donut-label\">" + label + "<br/>" + Math.round(series.percent) + "%</div>";
    }

    function randomVal() {
        return Math.floor(Math.random() * 80);
    }


    // init flot chart: vertical bar chart
    function chartBarVertical(placeholder) {
        var pengajuan = [
            [gt(2013, 10, 21), 188], [gt(2013, 10, 22), 205], [gt(2013, 10, 23), 250], [gt(2013, 10, 24), 230], [gt(2013, 10, 25), 245], [gt(2013, 10, 26), 260], [gt(2013, 10, 27), 290]
        ];

        var disetujui = [
            [gt(2013, 10, 21), 100], [gt(2013, 10, 22), 110], [gt(2013, 10, 23), 155], [gt(2013, 10, 24), 120], [gt(2013, 10, 25), 135], [gt(2013, 10, 26), 150], [gt(2013, 10, 27), 175]
        ];

        var plot = $.plot(placeholder,
                [
                    {
                        data: pengajuan,
                        label: "Pengajuan"
                    },
                    {
                        data: disetujui,
                        label: "Disetujui"
                    }

                ],
                {
                    bars: {
                        show: true,
                        barWidth: 15 * 60 * 60 * 300,
                        fill: true,
                        order: true,
                        lineWidth: 0,
                        fillColor: {colors: [{opacity: 1}, {opacity: 1}]}
                    },
                    grid: {
                        hoverable: true,
                        clickable: true,
                        borderWidth: 0,
                        tickColor: "#E4E4E4",

                    },
                    colors: ["#d9d9d9", "#5399D6", "#d7ea2b"],
                    yaxis: {
                        font: {color: "#555"},
                    },
                    xaxis: {
                        mode: "time",
                        timezone: "browser",
                        minTickSize: [1, "day"],
                        timeformat: "%a",
                        font: {color: "#555"},
                        tickColor: "#fafafa",
                        autoscaleMargin: 0.2
                    },
                    legend: {
                        labelBoxBorderColor: "transparent",
                        backgroundColor: "transparent"
                    },
                    tooltip: true,
                    tooltipOpts: {
                        content: '%s: %y'
                    }
                }
        );
    }


}); // end ready function