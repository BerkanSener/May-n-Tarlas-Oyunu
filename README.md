Mayın Tarlası oyunu, kullanıcının belirli bir alanda mayınları bulma amacına dayanan bir mantık oyunudur. İşte kullanıcıdan alınan dizin boyutlarıyla Mayın Tarlası oyununu oynamak için temel adımlar:
Oyunu Başlatın:
Oyuncudan satır, sütun ve mayın sayısı gibi oyun parametrelerini girmesini istenir. 
2 den fazla girmişse, diziye ait eleman sayısının 1/4 ü kadar rastgele mayın yerleştirilmelidir.
Eğer dizinin boyutu 2 den az ise "Geçersiz koordinatlar. Lütfen tekrar girin." uyarısını verdik. 

Oyunu Oynayın:
Kullanıcıya oyun alanını gösterdik ve bir hücre seçmesini istedik.
Kullanıcının seçtiği hücreyi açtık ve etrafındaki mayın sayısını gösterdik.
Eğer seçilen hücrede mayın varsa, oyunu kaybettiniz uyarısını verdik.
Eğer seçilen hücrede mayın yoksa, oyuncuya devam etme şansı verdik.

Oyun Sonucunu Gösterin:
Eğer oyuncu tüm mayınsız hücreleri açarsa, oyunu kazanmıştır.
Eğer oyuncu bir mayına basarsa, oyunu kaybetmiştir.
