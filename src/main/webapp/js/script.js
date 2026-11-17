
async function addrule() {

    const tbody = document.getElementById("t-body");
    tbody.innerHTML = "";

    const ruleCategory = document.getElementById("category").value;
    const ruleNo = document.getElementById("ruleNo").value;
    const ruleName = document.getElementById("ruleName").value;
    const startLimitHour = document.getElementById("limit-start").value;
    const endLimitHour = document.getElementById("limit-end").value;

    const response = await fetch("http://localhost:8080/smartcity360/policy", {
        method: "POST",
        body: JSON.stringify({
            ruleCategory: ruleCategory,
            ruleNo: ruleNo,
            ruleName: ruleName,
            startLimitHour: startLimitHour,
            endLimitHour: endLimitHour

        })
    });

    if (response.ok) {
        const data = await response.json();
        addTableData(data,tbody);

        reset();
    }


}


async function updaterule() {

    const tbody = document.getElementById("t-body");
    tbody.innerHTML = "";

    const ruleCategory = document.getElementById("category").value;
    const ruleName = document.getElementById("ruleName").value;
    const startLimitHour = document.getElementById("limit-start").value;
    const endLimitHour = document.getElementById("limit-end").value;
    const ruleNo = document.getElementById("ruleNo").value;


    const response = await fetch("http://localhost:8080/smartcity360/policy", {
        method: "PUT",
        body: JSON.stringify({
            ruleCategory: ruleCategory,
            ruleNo: ruleNo,
            ruleName: ruleName,
            startLimitHour: startLimitHour,
            endLimitHour: endLimitHour

        })
    });

    if (response.ok) {
        const data = await response.json();
       addTableData(data,tbody);

    }

    reset();
}

function addTableData(data,tbody){

    data.rules.forEach(rule => {

        let data = ` <tr>
                            <td>${rule.ruleCategory}</td>
                            <td>${rule.ruleNo}</td>
                            <td>${rule.ruleName}</td>
                            <td>${rule.limitTime}</td>
                        </tr>`;


        tbody.innerHTML += data;

    });

}


function reset() {
    document.getElementById("category").value = "Select";
    document.getElementById("ruleName").value = "";
    document.getElementById("limit-start").value = "";
    document.getElementById("limit-end").value = "";
    document.getElementById("ruleNo").value = "";
}