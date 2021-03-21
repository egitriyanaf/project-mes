////PAGES Dashboard
//const $mainDashboard = $('#mainDashboard');
//
////MODALAS
//const $modalFilterData = $mainDashboard.find('#modalFilterData');
//
//
////DATE RANGE PICKER---------------------------------------------------
////$modalFilterData.find('#rangeMonthInput').daterangepicker({
////    format: 'DD-MMM-YYYY',
////    autoUpdateInput: false,
////    opens: 'left',
////    locale: {
////        cancelLabel: 'Clear'
////    }
////});
//
//$mainDashboard.on('click', function (e) {
//    var id = e.target.id;
//    if (id === 'btnFilterDashboard') {
//        clearInputForm($modalFilterData);
//        $modalFilterData.modal('show');
//    }
//});

new Chart(document.getElementById("bar-chart-grouped"), {
    type: 'bar',
    data: {
        labels: ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
        datasets: [
            {
                label: "Jumlah Pengajuan",
                backgroundColor: "#49BE8B",
                data: [203, 221, 783, 342, 321, 341, 342, 341, 445, 654, 312, 543]
            }, {
                label: "Pengajuan disetujui",
                backgroundColor: "#59A7E1",
                data: [408, 547, 675, 734, 456, 202, 432, 124, 543, 433, 54, 54]
            }
        ]
    }
});