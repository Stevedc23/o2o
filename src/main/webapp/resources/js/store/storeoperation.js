
$(function() {
    var initUrl = '/o2o/storeadmin/getstoreinitinfo';
    var registerStoreUrl = 'o2o/storeadmin/registerstore';

    alert(initUrl);
    alert("Hello there");
    getStoreInitInfo();

    function getStoreInitInfo() {
        $.getJSON(initUrl, function(data) {
            if(data.success) {
                var tempHtml = '';
                var tempAeaHtml = '';
                data.storeCategoryList.map(function(item, index){
                    tempHtml += '<option data-id="' + item.storeCategoryId + '">' + item.storeCategoryName + '</option>';
                });
                data.areaList.map(function(item, index) {
                    tempAeaHtml += '<option data-id="' + item.areaId + '">' + item.areaName + '</option>';
                });

                $('#store-category').html(tempHtml);
                $('#area').html(tempAeaHtml);
            }
        });

        $('submit').click(function () {
            var store = {};
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

            $.ajax({
                url : registerStoreUrl,
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
                }
            });
        });
    }
})