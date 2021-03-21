new Chart(document.getElementById("doughnut-chart"), {
    type: 'doughnut',
    data: {
        labels: ["Pending proses klaim", "Keseluruhan klaim mitra"],
        datasets: [
            {
                label: "Population (millions)",
                backgroundColor: ["#1561A5", "#7ED2FF"],
                data: [2478, 5267]
            }
        ]
    },
    options: {
        title: {
            display: true,
            text: 'Presentase'
        }
    }
});

const search = {
    search: {status: '0'}
};

_fw_post('/dashboard/getStatusKlaim', search, function (data) {
    console.log(data);
});

(function () {
    const search = {
        search: {status: '0'}
    };
    
    _fw_post('/dashboard/getStatusKlaim', search, function (data) {
        console.log(data);
    });
})();