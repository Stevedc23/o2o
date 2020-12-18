
$(function() {
    var storeId = getQueryString('storeId');
    var isEdit = storeId ? true : false;
    var initUrl = '/o2o/storeadmin/getstoreinitinfo';
    var registerStoreUrl = 'o2o/storeadmin/registerstore';
    var storeInfoUrl = '/o2o/storeadmin/getstorebyid?storeId=' + storeId;
    var editStoreUrl = '/o2o/storeadmin/modifystore';

    //alert(initUrl);
    //alert("Hello there");
    if(!isEdit) {
        getStoreInitInfo();
    } else {
        getStoreInfo(storeId);
    }

    function getStoreInitInfo() {
        $.getJSON(initUrl, function (data) {
            if (data.success) {
                var tempHtml = '';
                var tempAeaHtml = '';
                data.storeCategoryList.map(function (item, index) {
                    tempHtml += '<option data-id="' + item.storeCategoryId + '">' + item.storeCategoryName + '</option>';
                });
                data.areaList.map(function (item, index) {
                    tempAeaHtml += '<option data-id="' + item.areaId + '">' + item.areaName + '</option>';
                });

                $('#store-category').html(tempHtml);
                $('#area').html(tempAeaHtml);
            }
        });
    }

    function getStoreInfo(storeId) {
        $.getJSON(storeInfoUrl, function (data) {
            if(data.success) {
                var store = data.store;
                $('#store-name').val(store.storeName);
                $('#store-addr').val(store.storeAddr);
                $('#store-phone').val(store.phone);
                $('#store-desc').val(store.storeDesc);

                var storeCategory = '<option data-id = "'
                    + store.storeCategory.storeCategoryId + '"selected>'
                    + store.storeCategory.storeCategoryName + '</option>';
                var tempAreaHtml = '';
                data.areaList.map(function (item,index) {
                    tempAreaHtml += '<option data-id = "' + item.areaId +'">' + item.areaName + '</option>';
                });
                $('#store-category').html(storeCategory);
                $('#store-category').attr('disabled', 'disabled');
                $('#area').html(tempAreaHtml);
                $("#area option[data-id ='" + store.area.areaId + "']").attr('data-id', store.areaId);
            }
        })
    }

    $('submit').click(function () {
        var store = {};
        if(isEdit) {
            store.storeId = storeId;
        }
        store.storeName = $('#store-name').val();
        store.storeAddr = $('#store-addr').val();
        store.phone = $('#store-phone').val();
        store.storeDesc = $('#store-desc').val();
        store.storeCategory = {
            storeCategoryId : $('#store-category').find('option').not(function () {
                return !this.selected;
            }).data('id')
        };
        store.area = {
            areaId : $('#area').find('option').not(function () {
                return !this.selected;
            }).data('id')
        };
        var storeImg = $('#store-img')[0].files[0];
        var formData = new FormData();
        formData.append('storeImg', storeImg);
        formData.append('storeStr', JSON.stringify(store));

        var verifyCodeActual = $('#j-captcha').val();
        if (!verifyCodeActual) {
            $.toast('Please enter verify code!');
            return;
        }
        formData.append('verifyCodeActual', verifyCodeActual);

        $.ajax({
            url : (isEdit? editStoreUrl : registerStoreUrl),
            type :"POST",
            data : formData,
            contentType : false,
            processData : false,
            cache : false,
            success : function (data) {
                if(data.success) {
                    $.toast('submit success');
                } else  {
                    $.toast('submit failed!' + data.errMsg);
                }
                $('#captcha-img').click();
            }
        });
    });
})