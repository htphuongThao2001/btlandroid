package com.example.truyenchu.database;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class databasedoctruyen extends SQLiteOpenHelper {

//    Cơ sở dữ liệu

    //    Tên database
    private static String DATABASE_NAME = "doctruyen";
    private static int VERSION = 1;
    //    Biến bảng truyện
    private static String TABLE_TRUYEN = "truyen";
    private static String ID_TRUYEN = "idtruyen";
    private static String TEN_TRUYEN = "tieude";
    private static String NOI_DUNG = "noidung";
    private static String IMAGE = "anh";
    private static String ID_LOAITRUYEN = "idloaitruyen";


    // context
    private Context context;


    //    biến lưu câu lệnh tạo bảng truyện
    private String SQLQuery = "CREATE TABLE " + TABLE_TRUYEN + " ( " + ID_TRUYEN + " integer primary key AUTOINCREMENT, "
            + TEN_TRUYEN + " TEXT UNIQUE, "
            + NOI_DUNG + " TEXT, "
            + IMAGE + " TEXT, "
            + ID_LOAITRUYEN + "integer )";

    //    Insert truyện

    private String SQLQuery1 = "INSERT INTO truyen VALUES (null,'Củ cải trắng','Mùa đông đã đến rồi trời lạnh buốt, Thỏ con không có gì để ăn cả. Thỏ con mặc áo vào rồi ra ngoài kiếm thức ăn. Nó đi mãi đi mãi cuối cùng cũng tìm được hai củ cải trắng. Thỏ con reo lên:\n" +
            "\n" +
            "– Ôi, ở đây có hai củ cải trắng liền, mình thật là may mắn!\n" +
            "\n" +
            "Thỏ con đói bụng, muốn ăn lắm rồi. Nhưng Thỏ lại nghĩ:\n" +
            "\n" +
            "– Ừm… trời lạnh thế này, chắc Dê con cũng không có cái gì để ăn đâu. Mình phải mang cho Dê con một củ mới được.\n" +
            "\n" +
            "Thế là Thỏ con đi sang nhà bạn Dê nhưng Dê con không có nhà nên Thỏ đặt củ cải lên bàn rồi đi về.\n" +
            "\n" +
            "Tình cờ, Dê con đi chơi cũng tìm được một củ cải trắng nhưng nó chỉ ăn trước một nửa.\n" +
            "\n" +
            "Về đến nhà, lại thấy có một củ cải trắng ở trên bàn Dê thèm ăn lắm, nhưng lại nghĩ:\n" +
            "\n" +
            "– Ôi trời lạnh thế này chắc Hươu con không có cái gì để ăn rồi, mình phải mang cho Hươu con mới được.\n" +
            "\n" +
            "Dê con đến nhà Hươu nhưng Hươu lại đi vắng, Dê con bèn đặt củ cải ở trên bàn rồi về.\n" +
            "\n" +
            "Khi Hươu về nhà, thấy củ cải ở trên bàn, Hươu ngạc nhiên lắm.\n" +
            "\n" +
            "– Ồ, củ cải trắng ở đâu mà ngon vậy nhỉ. Xuỵt… thích quá. Nhưng chắc trời lạnh thế này, Thỏ con cũng không có gì ăn đâu. Mình phải mang sang cho Thỏ mới được.\n" +
            "\n" +
            "Khi Hươu đến thì Thỏ con đang ngủ rất say. Khi tỉnh dậy Thỏ lại thấy trên bàn mình xuất hiện một củ cải trắng.Thỏ vui lắm nó chạy đi gọi các bạn:\n" +
            "\n" +
            "– Bạn Hươu ơi, bạn Dê ơi hãy đến nhà tôi, chúng ta cùng ăn củ cải trắng thơm ngon này.\n" +
            "\n" +
            "Thế là cuối cùng, củ cải trắng ấy được chia sẻ cho cả ba người bạn tốt bụng của chúng ta. Các bạn thấy đấy tấm lòng thơm thảo, sẵn sàng sẻ chia của các bạn ấy thật là đáng học tập phải không nào?\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Khi cho đi bạn sẽ nhận lại được nhiều hơn những thứ mình có.','https://i.pinimg.com/474x/0a/cf/11/0acf1114a9ab6fb1cff04b1a3d3507cc.jpg',2)";
    private String SQLQuery2 = "INSERT INTO truyen VALUES (null,'Dê đen và dê trắng','Dê đen và Dê trắng cùng sống trong một khu rừng. Hàng ngày, cả hai thường đến uống nước và tìm cái ăn ở trong khu rừng quen thuộc.\n" +
            "\n" +
            "Một hôm, Dê trắng đi tìm cái ăn và uống nước suối như mọi khi. Dê đang mải mê ngặm cỏ, bất chợt một con Sói ở đâu nhảy xổ ra. Sói quát hỏi:\n" +
            "\n" +
            "- Dê kia! Mi đi đâu?\n" +
            "\n" +
            "Dê trắng sợ rúm cả người, lắp bắp:\n" +
            "\n" +
            "– Dạ, dạ, tôi đi tìm… tìm cỏ non và…và uống nước suối ạ!\n" +
            "\n" +
            "Sói lại quát hỏi:\n" +
            "\n" +
            "– Mi có gì ở chân?\n" +
            "\n" +
            "– Dạ, dạ, chân của tôi có móng ạ…ạ!\n" +
            "\n" +
            "– Trên đầu mi có gì?\n" +
            "\n" +
            "– Dạ, dạ, trên đầu tôi có đôi sừng mới nhú…\n" +
            "\n" +
            "Sói càng quát to hơn:\n" +
            "\n" +
            "– Trái tim mi thế nào?\n" +
            "\n" +
            "– Ôi, ôi, trái…trái tim tôi đang run sợ…sợ…\n" +
            "\n" +
            "– Hahaha…\n" +
            "\n" +
            "Sói cười vang rồi ăn thịt chú Dê trắng tội nghiệp\n" +
            "\n" +
            "Dê đen cũng đi tới khu rừng để ăn cỏ non và uống nước suối. Đang tha thẩn ngặm cỏ, chợt Sói xuất hiện, nó quát hỏi:\n" +
            "\n" +
            "– Dê kia, mi đi đâu?\n" +
            "\n" +
            "Dê đen nhìn con Sói từ đầu tới chân rồi ngước cổ trả lời:\n" +
            "\n" +
            "– Ta đi tìm kẻ nào thích gây sự đây!\n" +
            "\n" +
            "Sói bị bất ngờ, nó hỏi tiếp:\n" +
            "\n" +
            "– Thế dưới chân mi có gì?\n" +
            "\n" +
            "– Chân thép của ta có móng bằng đồng.\n" +
            "\n" +
            "– Thế…thế…trên đầu mi có gì?\n" +
            "\n" +
            "– Trên đầu của ta có đôi sừng bằng kim cương!\n" +
            "\n" +
            "Sói sợ lắm rồi, nhưng vẫn cố hỏi:\n" +
            "\n" +
            "– Mi…mi…trái tim mi thế nào?\n" +
            "\n" +
            "Dê đen dõng dạc trả lời:\n" +
            "\n" +
            "– Trái tim thép của ta bảo ta rằng: hãy cắm đôi sừng kim cương vào đầu Sói. Nào, Sói hãy lại đây.\n" +
            "\n" +
            "Ôi trời, sợ quá, con Sói ba chân bốn cẳng chạy biến vào rừng, từ đó không ai trông thấy nó lởn vởn ở khu rừng đó nữa.\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Qua câu chuyện ngụ ngôn trên, bạn có thể truyền tải nhiều thông điệp khác nhau cho bé hiểu. Chẳng hạn như biết cách ứng xử trước các tình huống khó, nguy hiểm, lạc quan và bản lĩnh để xử lý vấn đề.','https://toplist.vn/images/800px/de-den-va-de-trang-230182.jpg',2)";
    private String SQLQuery3 = "INSERT INTO truyen VALUES (null,'Chú bé chăn cừu','Một chú bé chăn cừu cho chủ thả cừu gần một khu rừng rậm cách làng không xa lắm. Chăn cừu được ít lâu, chú cảm thấy công việc chăn cừu thực là nhàm chán. Tất cả mọi việc chú có thể làm để giải khuây là nói chuyện với con chó hoặc thổi chiếc sáo chăn cừu của mình.\n" +
            "\n" +
            "Một hôm, trong lúc đang ngắm nhìn đàn cừu và cánh rừng yên tĩnh chú bé chợt nhớ tới lời chủ của chú từng dặn rằng khi sói tấn công cừu thì phải kêu cứu để dân làng nghe thấy và đánh đuổi nó đi.\n" +
            "\n" +
            "Thế là chú nghĩ ra một trò chơi cho đỡ buồn. Mặc dù chẳng thấy con sói nào, chú cứ chạy về làng và la to:\n" +
            "\n" +
            "– Sói ! Sói !\n" +
            "\n" +
            "Đúng như chú nghĩ, dân làng nghe thấy tiếng kêu bỏ cả việc làm và tức tốc chạy ra cánh đồng. Nhưng khi đến nơi, họ chẳng thấy sói đâu, chỉ thấy chú bé ôm bụng cười ngặt nghẽo vì đã lừa được họ.\n" +
            "\n" +
            "Ít ngày sau chú bé chăn cừu lần nữa lại la lên:\n" +
            "\n" +
            "– “Sói ! Sói !”.\n" +
            "\n" +
            "Và một lần nữa dân làng lại chạy ra giúp chú. Nhưng họ lại chẳng thấy con sói nào, chỉ thấy chú bé chăn cừu nghịch ngợm ôm bụng cười khoái chí.\n" +
            "\n" +
            "Thế rồi vào một buổi chiều nọ, khi mặt trời lặn xuống sau cánh rừng và bóng tối bắt đầu phủ đầy lên cánh đồng, một con sói thực sự xuất hiện. Nó nấp sau bụi cây rình bắt những con cừu béo non. Bỗng sói phóng vút ra chộp lấy một chú cừu tội nghiệp. Thấy sói cả đàn cừu sợ hãi chạy toán loạn, chú bé chăn cừu cũng hoảng loạn vô cùng.\n" +
            "\n" +
            "Quá hoảng sợ, chú bé chăn cừu vội chạy về làng và la to:\n" +
            "\n" +
            "– “Sói ! Sói !”.\n" +
            "\n" +
            "Nhưng mặc dù dân làng có nghe tiếng chú kêu, không một ai chạy ra để giúp chú như những lần trước cả. Vì mọi người nghĩ chú lại bày trò nói dối như trước.\n" +
            "\n" +
            "Thế là sói thỏa sức bắt mồi, giết chết rất nhiều cừu của chú bé. Sau khi đã chén no nê, nó biến mất vào rừng rậm. Chú bé buồn bã ngồi giữa đồng cỏ, lòng đầy hối hận về hành động nói dối của mình và hậu quả của trò đùa dại dột gây ra.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Nói dối là một tật xấu. Người hay nói dối ngay cả khi nói thật cũng không ai tin.','https://toplist.vn/images/800px/chu-be-chan-cuu-230183.jpg',2)";
    private String SQLQuery4 = "INSERT INTO truyen VALUES (null,'Cậu bé chăn cừu và cây đa cổ thụ','Ngày xửa ngày xưa, xưa lắm rồi khi mà muôn thú, cây cỏ, con người còn trò chuyện được với nhau. Trên đồng cỏ rậm ven khu làng có một loài cây gọi là cây đa. Đó là một thứ cây to, khỏe, lá của nó rậm rạp đến nỗi không một tia nắng nào có thể lọt qua được. Vào những ngày trời nắng nóng người ta thường nghỉ chân một lát và trò chuyện hàn huyên cùng cây dưới bóng cây mát rượi. Mọi người ai cũng biết rằng cây đa rất thông thái vì cây đã có tuổi, đã từng trải.\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://i.vdoc.vn/data/image/2020/05/14/truyen-ngan-hay-cho-thieu-nhi-5.jpg',1)";
    private String SQLQuery5 = "INSERT INTO truyen VALUES (null,'Sự tích Hồ Ba Bể','Hằng năm, dân làng Năm Mẫu đều sẽ tổ chức cúng Phật lớn, gọi là lễ Vô Giá, dân chúng tập trung lại rất đông. Một hôm, có bà lão xuất hiện, quần áo rách tả tơi, bị mắc bệnh cùi hủi, bà đi xin ăn thì ai cũng xua đuổi vì sợ lây bệnh. Tuy nhiên, có một người đàn bà góa chồng sống cùng với con trai đã động lòng thương hại nên cho bà lão ăn uống đầy đủ và ở lại một đêm.\n" +
            "\n" +
            "Sáng hôm sau bà lão nói với hai mẹ con bà không phải là người phàm, chỉ giả ăn mày để thử lòng dân làng Năm Mẫu, và cho biết sắp có đại nạn. Khi gặp đại nạn thì hai mẹ con chỉ cần chạy lên đỉnh núi cao thì có thể tránh được, sau đó bà lão biến mất.\n" +
            "\n" +
            "Qua ngày hôm sau có đại nạn xảy ra thật, nước ở đâu cuồn cuộn đổ tới tứ phía, tràn vào thung lũng. Người ta trèo lên mái nhà, trèo lên cây. Nhưng nước cứ dâng tràn đầy lên mãi, ngập cả những nóc nhà và cây cao. Cả làng đều bị chết hết, chỉ có hai mẹ con góa chồng là sống sót nhờ làm theo lời chỉ dẫn của bà lão.\n" +
            "\n" +
            "Cả thung lũng bị nước ngập hóa thành 3 cái hồ rộng lớn, mênh mông như bể nên được gọi là hồ Ba Bể. Còn hai mẹ con góa chồng thì dựng một gian nhà nhỏ sinh sống trên núi, về sau nơi này trở thành một ngôi làng đông đúc và vẫn có tên là làng Năm Mẫu.\n" +
            "\n" +
            "Rút ra bài học ý nghĩa cho bé:\n" +
            "\n" +
            "Nhờ có tấm lòng nhân hậu mà mẹ con người phụ nữ góa chồng đã thoát khỏi thiên tai. Từ đó cần phải biết yêu thương, giúp đỡ người khác khi gặp khó khăn và khi mình gặp khó khăn thì mọi người cũng sẽ giúp đỡ lại.','https://yt.cdnxbvn.com/medias/uploads/186/186650-truyen-co-tich-ho-ba-be.jpg',1)";

    private String SQLQuery6 = "INSERT INTO truyen VALUES (null,'Sự tích cây vú sữa','Ngày xưa, có một cậu bé được mẹ cưng chiều nên rất nghịch và ham chơi. Một lần bị mẹ mắn đã bỏ nhà đi la cà khắp nơi. Mẹ cậu ở nhà mong ngóng con, một thời gian trôi qua mà vẫn không về, vì quá đau buồn nên người mẹ đã qua đời. Một hôm đi lang thang vừa đói, vừa mệt, lại bị trẻ lớn hơn đánh cậu mới nhớ đến mẹ mình và quay về. Khi cậu quay về thì thấy mọi cảnh vật vẫn như xưa nhưng không thấy mẹ đâu nên khản tiếng gọi mẹ:\n" +
            "\n" +
            "- Mẹ ơi, mẹ đi đâu rồi, con đói quá !  Rồi cậu gục xuống, rồi ôm một cây xanh trong vườn mà khóc.\n" +
            "\n" +
            "Vừa gọi xong, cây xanh cậu bé ôm bỗng run rẫy, những đài hoa bé tí trổ ra, hoa tàn, quả xuất hiện và lớn nhanh, da căng mịn, xanh óng ánh. Cây xanh nghiêng cành một quả to rơi vào tay cậu bé nhưng quá chát, quả thứ hai lại quá cứng, đến quả thứ ba cậu khẽ bóp quanh quả, lớp vỏ mềm dần rồi nứt ra một kẽ nhỏ chảy ra một dòng sữa trắng ngọt và thơm giống như sữa mẹ. Cây xanh rung rinh cành lá và thì thào:\n" +
            "\n" +
            "- Ăn trái ba lần mới biết trái ngon. Con có lớn khôn mới hay lòng mẹ.\n" +
            "\n" +
            "Cậu bé òa khóc, cậu đã không còn mẹ nữa. Về sau, hạt của cây xanh được mọi người đem về gieo trồng và đặt tên là Cây vú sữa.\n" +
            "\n" +
            "Rút ra bài học ý nghĩa cho bé:\n" +
            "\n" +
            "Qua câu chuyện, chúng ta thấy được tấm lòng yêu thương con vô bờ bến của người mẹ, người con vì ham chơi không biết trân trọng đến khi mẹ mất rồi mới nhận ra. Khi kể chuyện bé nghe với những câu chuyện tương tự truyện cổ tích này, bố mẹ có thể dạy cho bé phải biết trân trọng người đã có công ơn sinh thành, phải biết hiếu thảo, yêu thương và quan tâm đến đấng sinh thành của mình.','https://truyendangian.com/wp-content/uploads/2020/03/truyen-co-tich-su-tich-cay-vu-sua.png',1)";

    private String SQLQuery7 = "INSERT INTO truyen VALUES (null,'Chuột Nhà và Chuột Đồng','Chuột Nhà và Chuột Đồng là bạn thân của nhau. Chuột Đồng sống ở nông thôn, ngày ngày ra đồng ăn thóc, cuộc sống rất vui vẻ, hạnh phúc. Chuột Nhà sống trong một hốc tường của một gia đình giàu có ở thành phố. Khi chủ nhà đi vắng, Chuột Nhà chạy ra trộm thức ăn: nào là đỗ, thóc, pho mát, mật ong,… Cuộc sống của Chuột Nhà cực kỳ sung sướng.\n" +
            "\n" +
            "Một hôm, Chuột Đồng mời Chuột Nhà đến ăn giỗ. Chuột Nhà diện lễ phục chốn đồng quê dự tiệc. Chuột Đồng mang đại mạch và thóc mà mình dự trữ được ra đãi khách. Chuột Nhà vừa ăn đại mạch và thóc vừa bảo Chuột Đồng:\n" +
            "\n" +
            "– Bạn thân mến ơi, bạn sống như một con kiến tầm thường vậy. Còn chỗ tôi thì có bao nhiêu là thứ ngon. Bạn hãy lên thành phố hưởng thụ với tôi.\n" +
            "\n" +
            "Nghe bùi tai, thế là Chuột Đồng theo Chuột Nhà lên thành phố sinh sống. Trong bếp nhà chủ của Chuột Nhà, Chuột Đồng thấy có đỗ, thóc, lại còn có cả pho mát, mật ong,… Nó thèm đến nỗi nước miếng cứ chảy ra ròng ròng.\n" +
            "\n" +
            "Không ngờ Chuột Nhà lại có lắm cái ăn như vậy, nó rất ngưỡng mộ Chuột Nhà.\n" +
            "\n" +
            "Khi chúng đang chuẩn bị đánh chén thì có tiếng người mở cửa bếp. Chuột Nhà nhát gan, nghe thấy tiếng động liền ba chân bốn cẳng chui tọt vào hang.\n" +
            "\n" +
            "– Chủ nhà đấy! Chạy mau đi!\n" +
            "\n" +
            "Cả hai con chuột chạy như bay. Khi xung quanh yên tĩnh trở lại chúng mới dám chui ra. Vừa định cầm miếng pho mát lên thì lại có người mở cửa tiếp. Chuột Nhà lại vội vàng trốn vào hang.\n" +
            "\n" +
            "– Chủ nhà lại đến kìa, chạy đi!\n" +
            "\n" +
            "Chuột Đồng cũng chạy chối chết. Lúc này, Chuột Đồng đói đến mức bụng kêu òng ọc. Nó run run nói với Chuột Nhà:\n" +
            "\n" +
            "– Tạm biệt bạn thân mên! Bạn cứu việc hưởng thụ những thứ ngon lành này đi, còn tôi không muốn cứ phải nơm nớp lo sợ như thế nữa. Tôi sẽ quay về ăn thóc, sống một cuộc sống bình thường và yên ổn.\n" +
            "\n" +
            "Ý nghĩa:\n" +
            "\n" +
            "Trong cuộc sống chúng ta không nên có tư tưởng đứng núi này trông núi nọ, đừng mơ tưởng đến những vị trí không phù hợp với bản thân.\n" +
            "\n" +
            "Một cuộc sống giản dị nhưng vui vẻ, hạnh phúc còn hơn là sung túc, ăn ngon mặc đẹp, nhưng luôn phải lo lắng, sợ hãi.','https://thegioicotich.vn/wp-content/uploads/2021/09/chuot-nha-va-chuot-dong.jpg',2)";
    private String SQLQuery8 = "INSERT INTO truyen VALUES (null,'Rùa và Thỏ','Trời mùa thu mát mẻ. Trên bờ sông có một con Rùa đang cố sức tập chạy. Một con Thỏ trông thấy, mỉa mai nói đùa với Rùa:\n" +
            "\n" +
            "– Chậm như cậu mà cũng đòi tập chạy à?\n" +
            "\n" +
            "Rùa đáp:\n" +
            "\n" +
            "– Anh đừng giễu tôi. Anh với tôi thử chạy thi coi ai hơn?\n" +
            "\n" +
            "Thỏ vểnh tai lên tự đắc:\n" +
            "\n" +
            "– Được, được! Cậu dám thi chạy với tôi sao? Tôi chấp cậu một nửa đường đó!\n" +
            "\n" +
            "Rùa không nói gì. Nó biết mình chậm chạp, nên cố sức chạy thật nhanh. Thỏ nhìn theo mỉm cười. Nó nghĩ:\n" +
            "\n" +
            "– Ta chưa cần phải chạy vội, đợi Rùa gần tới đích, ta phóng cũng vừa.\n" +
            "\n" +
            "Thỏ nhởn nhơ trên đường, nhìn trời, nhìn mây. Thỉnh thoảng, nó lại nhấm nháp vài ngọn cỏ non, có vẻ khoan khoái lắm.\n" +
            "\n" +
            "Bỗng Thỏ nghĩ đến cuộc thi, ngẩng đầu lên thì thấy Rùa đã gần tới đích. Thỏ cắm cổ chạy miết nhưng không kịp nữa. Rùa đã tới đích trước nó.','https://thegioicotich.vn/wp-content/uploads/2021/02/rua-va-tho.jpg',2)";


    private String SQLQuery9 = "INSERT INTO truyen VALUES (null,'Con Cáo và chùm nho','Một con Cáo đang rất đói, bỗng nhìn thấy những chùm nho lủng lẳng trên cây được uốn dọc theo một cái giàn cao. Nó cố gắng nhảy cao hết mức có thể để lấy cho được những chùm nho này. Nhưng vô ích, vì chum nho ở quá cao.\n" +
            "\n" +
            "Cuối cùng, con Cáo bỏ đi với vẻ thờ ơ và có một chút tự trong. Nó tự bảo mình:\n" +
            "\n" +
            "– Những chùm nho này đã chín, nhưng hình như chúng còn chua lắm!\n" +
            "\n" +
            "Ý nghĩa câu chuyện:\n" +
            "\n" +
            "Truyện ngụ ý nói đến việc cố phủ nhận giả tạo một mong muốn vì không đạt được hoặc chê bai và giả vờ khinh khi những gì mà một người không đạt được.\n" +
            "\n" +
            "Mặt khác, câu chuyện cũng khuyên người ta nên biết từ bỏ những thứ không thuộc về mình cho dù đã rất cố gắng để đạt được.','https://thegioicotich.vn/wp-content/uploads/2020/12/con-cao-va-chum-nho.jpg',2)";


    private String SQLQuery10 = "INSERT INTO truyen VALUES (null,'Cá bống thần','Ngày xưa có hai anh em. Người em hiền lành dễ mến, còn người anh thì ác độc, xấu tính.Một hôm, người anh rủ người em ra sông tát cá. Người anh bắt người em be bờ, đắp đập, tát nước, còn mình thì bắt hết cá, chẳng để sót lại một con nào. Người em vừa mệt, vừa buồn. Bỗng có một con cá bống nhỏ, bơi dưới chân người em và cất tiếng nói:\n" +
            "\n" +
            "– Anh hãy mang tôi về nhà nuôi đi.\n" +
            "\n" +
            "Người em mừng rỡ vớt con cá bống lên, đem về nhà bỏ vào bát nuôi, nâng niu như trẻ nhỏ. Cá bống lớn rất nhanh. Qua ngày đầu tiên nó đã to chật cả cái bát, người em phải thả nó và chậu.\n" +
            "\n" +
            "Ngày hôm sau nó đã lớn chật chậu. Người em phải đắp cái vũng to bằng nửa cái sân nhà cho cá vùng vẫy. Hai ngày sau cá lớn chật vũng. Người em đắp luôn một đoạn khe ở chỗ khuất và thả cá xuống. Chỉ vài ngày sau, cá lớn chật khe, to như một con trâu đực. Lúc này nó nói:\n" +
            "\n" +
            "– Tôi vốn là cá bống thần. Nhờ công anh chăm sóc, nay tôi đã lớn rồi, tôi với anh hãy kết nghĩa cà-lơ (bạn) [*] đi. Chúng ta đi xuôi dòng kênh này một chuyến cho vui.\n" +
            "\n" +
            "Người em bằng lòng, thịt gà, thổi cơm trắng mang đi. Cứ đến bữa ăn, người em xé thịt và cơm trắng cho cá ăn, còn mình thì chỉ ăn xương gà với cơm cháy.\n" +
            "\n" +
            "Trời nổi mây to gió lớn, người em vô cùng lo sợ. Cá nói:\n" +
            "\n" +
            "– – Không sao đâu, trời sẽ không mưa. Anh hãy leo lên cây cao. Nếu thấy mây kéo ùn phía dưới, anh quay mặt về phía đó giả buồn rầu. Nếu mây ùn về phía trên nước, anh cười thật to là được.\n" +
            "\n" +
            "Người em nghe theo, trèo mãi lên ngọn cây cao. Khi mây ùn ùn phía dưới ngọn nước người em mặt ủ rũ buồn rầu. Lúc sau, thấy mây ùn ùn phía trên, anh cười vang. Tiếng cười dội vào vách núi vang như sấm. Bỗng anh nghe thấy tiếng gầm rú dưới khe. Quay lại anh nhìn thấy cá bống thần đã giết chết con thuồng luồng khổng lồ. Cá gọi:\n" +
            "\n" +
            "– Người anh em ơi, hãy xuống mổ bụng con thuồng luồng mà lấy của cải đem về.\n" +
            "\n" +
            "Người em làm theo và lấy được rất nhiều vàng bạc của cải. Cá bống và người em trở về. Về đến nhà người em kể lại câu chuyện cho anh nghe và chia đôi số của cải lấy được cho anh. Lòng tham nổi lên, người anh không chịu nhận số của cải mà người em cho, hắn đòi đi một chuyến cùng với cá. Người em miễn cưỡng cho anh mượn cá và dặn không được để cho cá chết.\n" +
            "\n" +
            "Thế là người anh tham lam ra đi. Anh ta cũng được cá bống cho đi dọc khe chơi. Nhưng anh ta tham lam quá, anh ta ăn hết thịt gà và cho cá ăn xương, ăn lòng.Đến một khúc khe, trời cũng nổi cơn giông. Anh tham lam mừng quá, hỏi cá nên làm gì. Cá dặn anh ta như dặn người em. Nhưng vì mừng quá, nghe vội nghe vàng nên anh ta không nhớ rõ lời cá dặn. Đáng lẽ hắn phải buồn ủ rũ thì hắn lại cười to, khi cần cười to thì hắn lại buồn ủ rũ. Con thuồng luồng vùng lên mà cá chưa kịp chuẩn bị. Thế là nó cắn chết cá bống. Người anh vô cùng tức giận đập vào đầu cá, trở về nhà.\n" +
            "\n" +
            "Về đến nhà, người em mừng rỡ chạy ra hỏi anh có lấy được nhiều của cải không, người anh cau mặt quát:\n" +
            "\n" +
            "– Chú nói láo. Cá của chú chết ngoài khe kia kìa.\n" +
            "\n" +
            "Người em nghe tin cá chết vội chạy một mạch ra ngoài khe. Đến nơi thấy xác cá cứng đờ, người em than khóc mãi. Hồn cá bống thần hiện về nói thoảng qua tai anh:\n" +
            "\n" +
            "– Người anh em đừng khóc nữa. Hãy chặt đầu tôi mang về chôn giữa sân, tôi sẽ có cách giúp được anh.\n" +
            "\n" +
            "Người em liền chặt đầu cá đem về chôn ở sân như lời cá dặn. Mấy ngày sau ở chỗ đó mọc lên cây tre rất cao.Tre nói:\n" +
            "\n" +
            "– Khi nào nghe gió trên về, hãy nói: “Áo sống ta đâu?”, sẽ có áo đẹp. Khi nào thấy gió dưới thì kêu: “Bạc nén, nồi đồng của ta đâu?”. Lúc đó sẽ có nhiều bạc nén, nồi đồng.\n" +
            "\n" +
            "Người em làm theo lời cá dặn nên được rất nhiều vàng bạc, áo quần. Người anh nổi máu tham chạy ra gốc tre. Thấy gió trên thổi hắn nói Áo sống của ta đâu? Tức thì bao nhiêu rẻ rách trên trời rơi xuống. Thấy gió dưới nổi lên hắn thét Bạc nén, nồi đồng của ta đâu?Trên ngọn tre bao nhiêu sọ người, xương bò rơi xuống đầu người anh tham lam, làm anh ta đau điếng. Tức giận, anh ta chặt luôn cây tre và về nhà mắng người em:\n" +
            "\n" +
            "– Chú nói láo. Cây tre của chú là ma quỷ, anh chặt rồi.\n" +
            "\n" +
            "Người em chạy ra chỗ cây tre than khóc. Gốc tre nói với anh rằng Anh hãy đốt tôi đi lấy tro vào rừng. Thấy vết chân con thú nào anh hãy rải tro lên và đi theo, con thú sẽ chết, anh tha hồ có thịt ăn.\n" +
            "\n" +
            "Người em làm theo và mang về rất nhiều thịt thú rừng. Người anh tham lam nghe tin, giật số tro còn lại của người em đem ra rẫy. Hắn rải tro khắp nơi, thấy dấu chân chuột hắn cũng rải. Thấy dấu chân người hắn cũng rải vì nghi có kẻ trộm vào rẫy. Rải xong hắn hý hửng về nhà toan quét dọn nhà cửa để đi nhặt cọp, heo về.Về đến nhà, hắn thấy vợ và đàn con lăn ra chết giữa nhà. Hoảng hốt, hắn chạy ra rẫy. Té ra, những dấu chân hắn nghi là trộm lại chính là dấu chân của vợ con hắn. Hắn như điên như dại lấy nốt số tro còn lại rải lung tung, rải lên cả dấu chân của mình. Thế là chưa kịp về đến nhà hắn đã lăn ra chết.Người em nghe tin anh chết, vẫn lo lắng ma chay cho anh cho trọn tình trọn nghĩa. Từ đó người em sống yên ổn làm ăn cùng bà con xóm giềng.\n" +

            "\n" +
            "Ý nghĩa câu chuyện: Đừng tham lam.','https://thegioicotich.vn/wp-content/uploads/2021/08/ca-bong-than.jpg',1)";
    private String SQLQuery11 = "INSERT INTO truyen VALUES (null,'Sự tích gương soi','Vua Hùng thứ 18 có hai nàng công chúa tên là Tiên Dung và Ngọc Hoa. Một buổi sớm mùa xuân, hai nàng dậy sớm để đi hội. Qua một giống trong bên hồ sen thơm mát, Ngọc Hoa cúi múc nước rửa mặt. Tiên Dung vội ngăn lại vì nhìn thấy hình em hiện lên trong giếng nước.\n" +
            "\n" +
            "Ngọc Hoa sợ hãi, nín lặng nhìn xuống. Quả nhiên, dưới nước có gương mặt quen quen. Ngọc Hoa lắc đầu, gương mặ dưới nước cũng lắc theo. Ngọc Hoa đưa tay vuốt tóc mỉm cười, gương mặt dưới nước cũng cười theo. Nụ cười hiền quá. Ngọc Hoa kéo chị cùng nhìn vào. Rồi cả hai thích thú ngắm nhìn dung nhan mình trong giếng. Suýt nữa hai chị em bị nhỡ hội.\n" +
            "\n" +
            "Vua Hùng vốn yêu quý hai con gái. Biết chuyện, vua cho đào trong cung một cái giếng trong vắt. Phía trên có mái trổ để nâng lên cho ánh sáng hắt vào, in rõ mặt người. Từ đó giếng tròn nhắc cho hai chị em biết cách trang điểm và sửa lại mái tóc mình. Cứ thế, hai nàng ngày một xinh đẹp hơn. Họ sung sướng cảm tạ vua cha.Chuyện cái giếng tròn soi rõ bóng hai nàng công chúa lan ra. Trai gái xung quanh vùng rủ nhau soi mình xuống giếng mỗi khi đi trẩy hội… Sau này, người ta phát minh ra cách làm kính và gương soi. Nhưng vẫn giữ dáng gương giống như chiếc “giếng tròn”.\n" +
            "\n" +
            "Nếu có dịp về thăm đền Hùng, các bé sẽ được thăm lại chiếc gương tròn, trong như gương của vua Hùng thuở ấy.','https://sachhay24h.com/uploads/images/truyen-co-tich-ve-tinh-ban.jpg',1)";

    private String SQLQuery12 = "INSERT INTO truyen VALUES (null,'Quả đào tiên',' Có một cây đào lâu năm trên cành đơm đầy quả. Trong số những quả đào có một trái thực là to, no tròn hơn hẳn so với những quả còn lại. Dưới lớp lông mịn ánh bạc là vỏ đào đỏ ối chứ không phớt hồng như những quả dào khác.\n" +
            "\n" +
            "Quả đào trông thực là đẹp. Những quả đào khác trên cây nhìn nó với ánh mắt ngưỡng mộ pha chút thèm thuồng. Rất đắc ý, quả đào nọ luôn tự cho mình là chúa tể trong các quả đào.\n" +
            "\n" +
            "Một hôm, người chủ vườn đến hái đào, quả đào to và đỏ nọ liền kêu lên: “Tôi là Hoàng hậu của các quả đào, không được hái tôi”. Quả thật, người chủ vườn đã không hái nó. Từng sọt từng sọt đào lần lượt được chở ra chợ bán. Người ta tranh nhau mua đào về trưng trên bàn thờ tổ tiên, để biếu người già chúc thọ. Cả gia đình quây quần tận hưởng sắc thanh, vị thơm ngon của những trái đào. Dưới những mái nhà, không khí gia đình tràn ngập niềm vui và tiếng cười với sự xuất hiện của những quả đào.\n" +
            "\n" +
            "Chỉ còn lại quả đào “Hoàng hậu” trơ trọi một mình trên cây. Nắng hạ sương mù khiến nó mỗi ngày một tàn tạ. Vẻ đẹp kiêu sa của nó dần trở thành trái đào ủng. Cuối cùng, quả đào ấy rơi xuống đất thối rữa.Không biết khi lâm vào cảnh tiều tụy, quả đào nọ có hiểu ra rằng ý của cuộc sống nằm ở chỗ thể hiện được giá trị bản thân mình, khi nó trở nên có ích cho mọi người. Những quả đào khác trong câu chuyện đều đã làm được điều đó, duy chỉ có quả đào tự cho mình là “Hoàng hậu” thì lại rụng xuống đất một cách vô ích.\n" +
            "\n" +

            "Ý nghĩa câu chuyện: Đời người thật ngắn ngủi, để cuộc sống có ý nghĩa, mỗi người phải cố mang niềm vui và hạnh phúc đến cho những người khác.','https://thegioicotich.vn/wp-content/uploads/2021/09/cau-chuyen-qua-dao-tien.jpg',1)";


    //    Tạo bảng tại phương thức này
    public databasedoctruyen(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//        Thực hiện các câu lệnh truy vấn không trả về kết quả
        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
        db.execSQL(SQLQuery3);
        db.execSQL(SQLQuery4);
        db.execSQL(SQLQuery5);
        db.execSQL(SQLQuery6);
        db.execSQL(SQLQuery7);
        db.execSQL(SQLQuery8);
        db.execSQL(SQLQuery9);
        db.execSQL(SQLQuery10);
        db.execSQL(SQLQuery11);
        db.execSQL(SQLQuery12);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //lấy 4 truyện mới nhất
    public Cursor getData1() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT* FROM " + TABLE_TRUYEN + " ORDER BY " + ID_TRUYEN + " DESC LIMIT 4", null);
        return res;
    }

    //Lấy truyện cổ tích
    public Cursor getData2() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_TRUYEN+ " where  " + ID_LOAITRUYEN + " = 1" ,null);
        return res;
    }

    //lấy truyện
    public Cursor getData3() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =db.rawQuery("SELECT * FROM " + TABLE_TRUYEN ,null);
        return  res;
    }
}






