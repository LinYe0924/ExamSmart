function AJAXByPOST(url,data,successFunction,errorFunction) {
    $.ajax({
        url: url,
        type: "POST",
        data: data,
        dataType: 'json',
        async: true,
        success: successFunction,
        error: errorFunction == null ? function (reps) {
            document.write(reps.responseText);
            } : errorFunction
    })
}function AJAXByGet(url,data,successFunction , errorFunction) {
    $.ajax({
        url: url,
        type: "Get",
        data: data,
        dataType: 'json',
        async: true,
        success: successFunction,
        error: errorFunction == null ? function (reps) {
            document.write(reps.responseText);
        } : errorFunction
    })
}