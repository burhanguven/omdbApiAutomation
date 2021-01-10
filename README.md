
http://omdbapi.com/ 

Run etmek için dev.properties ve qa.properties den gelen baseUrl ile göre hangi ortamda çalışağını seçiyorum. Testimde tek ortam olduğu için ikisinde de aynı dataları ekledim.

omdbApiAutomation/src/test/java/omdbApiTest/MovieTest.java class ından Run Configurations-> Arguments -> VM arguments : -Denv=dev ya da -Denv=qa olarak  run edebilirsiniz. Eğer burada çalışılacak ortam verilmezse default olarak dev üzerinde çalışacaktır.

