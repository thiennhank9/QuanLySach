-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: quanlythuvien
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--
drop database if EXISTS quanlythuvien;
create database quanlythuvien;

use quanlythuvien;

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sach` (
  `idsach` varchar(45) NOT NULL,
  `tensach` varchar(450) NOT NULL,
  `tacgia` varchar(450) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gia` int(11) NOT NULL,
  `mota` varchar(5000) DEFAULT NULL,
  `ngaythem` varchar(45) NOT NULL,
  `ngaycapnhat` varchar(45) DEFAULT NULL,
  `loai` varchar(45) NOT NULL,
  `thoihanmuon` int(11) NOT NULL,
  PRIMARY KEY (`idsach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES ('IT001','Tìm Hiểu Về Công Nghệ Thông Tin','Nguyễn Nguyệt Minh 1',50,50000,'Loài người đang bước vào thời đại thông tin. Thông tin, thông tin hóa, thông tin xã hội và nhiều từ ngữ mới bao hàm nội dung này đều đang trở thành chủ đề nóng hổi của xã hội. Cuốn sách này chủ yếu giới thiệu về công nghệ thông tin hiện đại. Công nghệ thông tin ngày nay có quan hệ mật thiết với công nghệ máy tính, công nghệ tự động hóa. Do vậy, cuốn sách cũng giới thiệu cả về công nghệ máy tính và công nghệ tự động hóa nhằm đưa đến cho bạn đọc kiến thức tổng hợp và toàn diện. Cuốn sách gồm những nội dung chính như sau: Làm thế nào để kết nối điện thoại lại với nhau? Cáp quang Công nghệ Bluetooth Địa chỉ IP Truyền hình vệ tinh Mạng tích hợp IC Công nghệ WLAN Hệ thống định vị toàn cầu GPS','25/11/2015','19/12/2015','Sách Căn Bản',30),('IT002','Tự Học Nhanh Word 2013','Nguyễn Đức Hiếu ',50,35000,'Cuốn sách được biên soạn với mục đích củng cố kiến thức cơ bản, cập nhật các tính năng mới, trang bị các kỹ năng về ứng dụng WinWord cho người sử dụng máy tính. Sách trình bày về MS Office Word 2013 với những tính năng cơ bản và tiện dụng, hiện đại và tối ưu hóa giao diện. Nội dung sách gồm những nội dung chính như sau: - Làm quen với Microsoft Word 2013. - Soạn thảo văn bản. - Hiệu chỉnh văn bản. - Làm việc với bảng biểu. - Chèn các đối tượng vào văn bản. - In ấn.','25/11/2015',NULL,'Sách công nghệ thông tin',30),('IT003','Tự Học Corel Draw X4','Trí Việt - Hà Thành ',50,34000,'Corel DRAW là một công cụ dùng cho việc thiết kế đồ họa với khả năng tinh tế và tốc độ vượt trội của Corel DRAW trong việc thực hiện những sản phẩm \"văn hóa trực quan\". Bên cạnh ý tưởng sáng tạo của người thiết kế đồ họa, có thể nhận ra dấu ấn của Corel DRAW trong nhiều trang minh họa, quảng cáo, nhãn hiệu, bích chương. Ngoài ra, các chức năng vẽ chính xác làm cho Corel DRAW ngày càng được ưa chuộng trong việc thiết kế tài liệu, báo cáo thuộc các lĩnh vực khoa học kỹ thuật. Cuốn sách này giúp bạn tìm hiểu cách sử dụng Corel DRAW và rèn luyện những kỹ năng đồ họa căn bản nhất.','25/11/2015',NULL,'Sách công nghệ thông tin',30),('IT004','Học Nhanh Tin Học Văn Phòng','Hà Thành - Trí Việt ',50,52000,'Cuốn sách trình bày các kiến thức cơ bản về Hệ điều hành Windows XP, Microsoft Office 2003, về ứng dụng Internet, nhằm giúp người học trang bị nhanh nhất các kiến thức về tin học văn phòng. Nội dung sách gồm 5 phần: - Khám phá và làm việc trên hệ điều hành Windows - Các kiến thức Microsoft Word 2003 - Các kiến thức về Microsoft Excel 2003 - Các kiến thức về PowerPoint 2003 - Cách lập hòm thư gmail và Blog trên Google Internet','25/11/2015',NULL,'Sách công nghệ thông tin',30),('IT005','Hướng Dẫn Cách Bảo Mật Và Quản Trị Mạng Cho Người Tự Học','Hà Thành - Trí Việt ',50,37000,'Chương 1: Tìm hiểu mang máy tính Chương 2: Hệ điều hành mạng Windows NT Chương 3: IsaSever Enterprise 2000 Chương 4: Mạng internet và thủ thuật bảo mật và quản trị mạng','25/11/2015',NULL,'Sách công nghệ thông tin',30),('IT006','Tự Học C# Và SQL SERVER 2008','Ths. Tạ Minh Châu - KS. Hoàng Anh Quang ',50,44000,'Nền tảng dữ liệu Microsoft là một giải pháp xuyên suốt cần cho các thách thức đã tồn tại và hơn thế nữa, bằng việc đưa ra những cách tân trong bốn lĩnh vực chính nhằm hỗ trợ cho dữ liệu: Nền tảng cho các nhiệm vụ then chốt, phát triển động, dữ liệu quan hệ mở rộng, thông tin trong toàn bộ doanh nghiệp. Hãy tìm hiểu cách SQL Server 2008 đáp ứng những cần thiết cho thế hệ kế tiếp của các ứng dụng thao tác dữ liệu. Nội dung sách gồm các phần sau: Phần 1: Hệ quản trị cơ sở dữ liệu SQL ServerGiới thiệu về SQL Server 2008, Table và View... Phần 2: Xây dựng ứng dụng quản lý C#Giới thiệu chung về C#, Lập trình với CSDL...','19/12/2015',NULL,'Sách công nghệ thông tin',30),('IT007','25 Phương Pháp Sử Dụng Internet An Toàn','Nhiều Tác Giả ',50,54000,'Cuốn 25 phương pháp sử dụng Internet an toàn giới thiệu một cách khách quan, toàn diện về những điều tích cực và tiêu cực mà máy tính và mạng internet mang lại, giúp các bậc cha mẹ chủ động giảng dạy và ứng dụng các chương trình từ máy tính và mạng Internet, phòng tránh con cái nghiện máy tính và Internet. Từ đó, giúp trẻ có thể thực sự trở thành người thành công trong thời đại công nghệ thông tin.','25/11/2015',NULL,'Sách công nghệ thông tin',30),('IT008','Kỹ Năng Sử Dụng Máy Vi Tính Cho Người Mới Đi Làm','Ks. Hồng Hoàng Quang (biên soạn) ',50,32000,'Cuốn sách Kỹ Năng Sử Dụng Máy Vi Tính Cho Người Mới Đi Làm sẽ giúp bạn: -          Sử dụng phần mềm soạn thảo văn bản dành cho người mới đi làm… -          Sử dụng phần mềm bảng tính Excel dành cho người mới đi làm: Powerpoint -          Hướng dẫn sử dụng Internet, thư điện tử, tìm hiểu một số dịch vụ mail phổ biến, gmail, Hotmail, yahoomail…','03/12/2015',NULL,'Sách công nghệ thông tin',30),('IT009','Tự Học 3D Max','Trí Việt - Hà Thành ',50,30000,'Kiểu bố trí của Max khác hẳn với các chương trình khác mà bạn đã từng gặp. Nếu trước khi đến với Max mà bạn đã làm quen với photoshop và quen với các công cụ của nó thì bạn sẽ thấy một chút thất vọng vì kiểu trình bày các công cụ của Max \"quá phức tạp\" vì 3D> 2D. Nhưng bạn yên tâm khi đã quen rồi thì bạn sẽ thấy nó rất tiện lợi. Cuốn sách Tự học 3D Max giới thiệu tới bạn đọc những nội dung cơ bản sau: + Giao diện 3D Max: Hướng dẫn sử dụng các công cụ cơ bản trên bản vẽ, lệnh chỉnh sửa Poly trong 3D Max, hướng dẫn sử dụng các lệnh tạo khối trong Geometry… + Hướng dẫn cách chiếu sáng và sử dụng đèn chiếu trong 3D Max + Hướng dẫn cách gắn vật liệu trong 3D Max và thực hành dựng hình trên 3D Max','25/11/2015',NULL,'Sách công nghệ thông tin',30),('IT010','Tin Học Dành Cho Người Tự Học','Hà Thành - Trí Việt ',50,50000,'Cuốn sách đáp ứng nhu cầu của người sử dụng máy tính, với mục đích giúp người học có thể sử dụng thành thạo nhiều phần mềm ứng dụng khác nhau. Nội dung sách gồm 4 phần: Phần 1: Tìm hiểu các kiến thức cơ bản về phần cứng máy tính Phần 2: Kiến thức cơ bản về Windows XP Phần 3: Tự học các kiến thức cơ bản về các phần mềm tin học văn phòng Phần 4: Quản trị mạng','25/11/2015',NULL,'Sách công nghệ thông tin',30),('VH001','Nhà Thờ Đức Bà Paris (Đinh Tị)','Victor Hugo ',50,80000,'Nhà thờ Đức Bà Paris là tác phẩm tiêu biểu cho phong cách sáng tác theo khuynh hướng lãng mạn của Victor Hugo. Cũng nhờ thành công của tác phẩm mà ông được biết đến như một nhà văn nhân đạo, lãng mạn bậc nhất của nước Pháp. Bằng cốt truyện khá bi thảm, nặng nề, các tình tiết xếp đặt khéo léo, mang kịch tính và hình ảnh tô đậm, phóng đại, lẫn lộn thực hư, kết hợp với bút pháp miêu tả thật rực rỡ, kỳ thú, Victor Hugo đã vẽ nên một bức tranh thu nhỏ về xã hội Pháp thế kỷ XV. “Cạnh ngôi nhà thờ lớn cổ kính, Victor Hugo xây dựng một tòa nhà thờ lớn khác bằng thi ca, cũng vững chắc như nền móng, cũng ngất cao như dãy tháp của tòa nhà thờ nọ”.','25/11/2015',NULL,'Sách văn học tiểu thuyết',20),('VH002','Yêu Thương Trao Anh','Scotland Chiết Nhĩ Miêu ',50,125000,'Cuộc hôn nhân của hai người họ thực ra chỉ là một quyết định chóng vánh. Lương Hoà - cô phóng viên yếu đuối mang trong mình nỗi đau quá khứ, khi quyết định lấy anh chỉ đơn giản là vì cô cần một chỗ dựa và anh đã mang đến cho cô cảm giác bình an. Còn Cố Hoài Ninh đến với cô phải chăng là để tháo bỏ nút thắt trong lòng với hai người phụ nữ ở quá khứ và hiện tại? Bởi gia cảnh của mình, cô luôn thu mình trước anh và gia đình anh, cô thận trọng khi thể hiện tình cảm với anh và cũng thận trọng trước sự quan tâm của anh. Anh thì với bản tính quyết đoán, dứt khoát của nhà binh, cũng luôn thể hiện tình cảm với cô theo cách lạnh lùng điềm tĩnh nhất. Hai người họ kẻ qua người lại như thế, khiến cho đối phương vẫn luôn hoài nghi về tình cảm của mình, và họ trở nên xa cách - anh để mặc cô làm những gì mình thích, còn cô thì dường như luôn đứng ngoài cuộc sống của anh. Thứ tình cảm mong manh giữa hai người những tưởng sẽ khiến cho cuộc hôn nhân của họ trở nên nhạt nhoà, nhưng rồi những biến cố trong cuộc sống đã đưa họ đến gần nhau hơn. Từ việc đối phó với bà mẹ chồng luôn tìm mọi cách để được ở gần con trai và con dâu, việc đối phó với tay tổng biên tập luôn thầm thương trộm nhớ Lương Hoà, đến việc xử sự ra sao khi cô biết cô gái trước kia từng yêu anh đã chấp nhận lấy anh trai anh chỉ vì muốn được ở gần anh rồi cuối cùng lại chết vì chứng stress trước khi sinh. Và đỉnh điểm hơn là khi sự thật về thân thế của cô cứ lần lượt bị phơi bày. Lương Hoà đã suy sụp khi biết rằng ba cô trước khi qua đời đã mang tội danh tham ô, và cảm giác mình không xứng với anh chưa bao giờ lớn đến vậy. Sau đó không lâu, cô lại biết được sự thật người chủ hôn trong đám cưới của cô - cũng là người thân thiết với gia đình nhà chồng cô lại chính là người ông đã bỏ rơi bà và mẹ cô. Cuộc sống của cô đã bị đảo lộn, gần như bị phá nát bởi những sự thật động trời đó. Nhưng anh vẫn luôn ở bên cô, điềm đạm, tỉ mỉ, nhưng cũng hết sức ân cần tha thiết và đong đầy yêu thương. Cô đã bị anh đánh gục bởi tình yêu chân thành, còn anh thì coi việc bảo vệ cô là lẽ sống, là mệnh lệnh không thể chối từ. Họ đã yêu nhau như thế, từng bước từng bước cùng nhau vượt qua sóng gió, và đã thực sự là một phần của nhau. Bình minh đến vén màn đêm đen tối, mọi thứ trở nên tươi đẹp hơn khi họ vui mừng chờ đón hai bảo bối đang lớn dần trong cơ thể cô từng giờ từng phút. Cô mở lòng mình đón nhận người ông đã từng gây ra lỗi lầm trong quá khứ, đón nhận sự quan tâm của người mẹ chồng mà cô đã từng rất sợ hãi và thậm chí là căm hận, và quan trọng là cô đã có cảm giác rất mạnh mẽ về thân phận của mình - Cô là vợ bộ đội, và Anh là chàng trung tá của cô, của một mình cô.','25/11/2015',NULL,'Sách văn học tiểu thuyết',20),('VH003','Tiếng Gọi Của Hoang Dã','Jack London ',50,32000,'Tiếng gọi của hoang dã là một tiểu thuyết của nhà văn Mỹ Jack London. Cốt truyện kể về một con chó tên là Buck đã được thuần hóa, cưng chiều. Nhưng một loạt các sự kiện xảy ra khi Buck bị bắt khỏi trang trại để trở thành chó kéo xe ở khu vực Alaska lạnh giá, trong giai đoạn mọi người đổ xô đi tìm vàng thế kỷ 19, thiên nhiên nguyên thủy đã đánh thức bản năng của Buck. Buck trở lại cuộc sống hoang dã, trở về rừng và sống chung với lũ sói.','25/11/2015',NULL,'Sách văn học tiểu thuyết',20),('VH004','Tây Du Hí','Mèo Mốc',50,41000,'Hòa trộn giữa Tây Du Kí của Ngô Thừa Ân với sự hài hước “thời thượng” từ Nhật kí Mèo Mốc, Tây Du Hí tạo ra một phong cách hài hước mới mẻ xứng đáng để bạn “móc hầu bao”. Ngày xửa ngày xưa, ở đất nước nọ có một hòn đảo nằm giữa biển, trên đảo có một quả núi gọi là Hoa Quả Sơn, trên đỉnh Hoa Quả Sơn có một bức tượng kì cục hình con gà mái… Một cái mở màn dài thòng chả liên quan gì tới truyện cho tới một ngày kia, bức tượng nứt ra một quả trứng, và quả trứng nở ra một con khỉ, và con khỉ ấy là Tôn Ngộ Không – nhân vật được vạn người mến mộ. Tôn Ngộ Không của Mèo Mốc là một con khỉ đá láo toét, thích quậy phá, ăn chơi nhảy múa tiệc tùng tại Hoa Quả Sơn. Cho đến ngày kia, chú ta nổi hứng lên đường đi tìm học phép trường sinh, đặng tìm kế sinh tồn trước cuộc sống đang ngày một trở nên “đáng sợ”. Ngày con khỉ Tôn của tác giả Mèo Mốc lên đường vượt biển, cũng là ngày bắt đầu chuyến hành trình hài hước và quái đản một cách đầy bất ngờ. Trong cuộc hành trình ấy, độc giả sẽ gặp lại những nhân vật đã vô cùng quen thuộc với tuổi thơ mình: tứ hải long vương, Bồ Đề Sư tổ, Hỗn Thế Ma vương… và rất nhiều những nhân vật lạ hoắc kì quặc khác không hiểu từ đâu cũng đột ngột “xé khung tranh” chui vào đòi đất diễn. Tuy chỉ khác danh tác lẫy lừng của Ngô Thừa Ân một chữ “h”, nhưng Tây Du Hí là một trải nghiệm mới khác xa cả tỉ dặm. Một bộ truyện hài hước, nhưng là một sự hài hước liền mạch, nối tiếp nhau từ trang này qua trang khác, theo một cốt truyện có sự phát triển, có cao trào và… ào ào các thứ khác. “Các thứ các” là gì, đó là điều Mèo Mốc để dành cho độc giả khám phá.','25/11/2015','27/11/2015','Sách văn học tiểu thuyết',20),('VH005','Thư Gửi Mùa Thu','Lệ Thu Huyền, September Rain, Mùa Đông, Petit Prince',50,48000,'Chúng ta ai rồi cũng đi qua những tháng ngày như thế. Những ngày mà dù thuộc về nhau hay không thì vẫn cất giữ một điều gì đó trong lòng. Những ngày dốc lòng sống vì một người xứng đáng rồi lặng lẽ quay lưng, lặng lẽ buông tay, lặng lẽ mỉm cười, lặng lẽ khóc. Thư gửi mùa thu là một bức vẽ bằng màu nỗi nhớ, không hình hài cụ thể nhưng vẫn khiến người ta chợt thấy một điều gì đó thân thuộc nhất. Ở đó có nỗi nhớ của một người thứ ba khóc cạn nước mắt cho một cuộc tình có bắt đầu nhưng muôn đời không tìm ra kết thúc. Có nỗi nhớ của hai người yêu nhau ở hai nơi cách biệt cả đại dương mênh mông. Hay đôi khi đơn thuần là nỗi nhớ cho một thành phố giấu đi cả khoảng trời ký ức. Ở đó, mùa thu chạm ngõ cùng một chiều mưa như để phố thỏa cơn khát sau chuỗi ngày gánh gồng hạt nắng. Ở đó có những lời hẹn ước của mùa xuân, có những vấn vương của mùa đông, có những tâm tình của mùa hạ gửi mùa thu xa nhớ... Mượn vay ấm áp và đau thương từ những khoảng trời khác biệt, Thư gửi mùa thu không chỉ là câu chuyện riêng của Lệ Thu Huyền, September Rain, Mùa Đông, Petit Prince mà sẽ rất nhiều người thảng hoặc thấy mình ở một tự sự nào đó, những câu chuyện bỏ ngỏ không của riêng ai...','25/11/2015',NULL,'Sách văn học tiểu thuyết',20),('VH006','Truyện Thúy Kiều','Nguyễn Du',50,35000,'Ấn bản do Bùi Kỷ và Trần Trọng Kim hiệu khảo \"Buồn trông cửa bế chiều hôm, Thuyền ai thấp thoáng cánh buồm xa xa Buồn trông ngọn nước mới sa, Hoa trôi man mác, biết là về đâu? Buồn trông nội cỏ dầu dầu Chân mây mặt đất một màu xanh xanh, BUồn trông gió cuốn mặt duyềnh, Ầm ầm tiếng sáng kêu quanh ghế ngồi... \"Truyện Kiều còn, tiếng ta còn; Tiếng ta còn, nước ta còn.\"','25/11/2015',NULL,'Sách văn học tiểu thuyết',20),('VH007','Tập Tục Quê Em - Lễ hội Ok Om Bok','Nấm Hương - Thùy An ',50,17000,'Cuối tuần, Bo được ba mẹ đưa về thăm ngoại. Nhà ngoại Bo nằm trong phum người Khmer sinh sống, nên cậu có dịp tham dự lễ hội Ok Om Bok lúc vụ mùa vừa kết thúc. Ngoài cốm đẹp, trầu, cau là những món không thể thiếu, thì các loại nông sản như khoai, sắn, chuối, dừa, bánh kẹo… sẽ làm phong phú mâm lễ dâng cúng thần Mặt Trăng. Bo vô cùng thích thú khi được xem và chơi các trò chơi dân gian như thả đèn gió, thả đèn nước, đua ghe ngo, kéo co… Dĩ nhiên Ok Om Bok còn chứa nhiều điều lạ lẫm, kì bí, đầy thu hút, mà những tranh vẽ sinh động trong cuốn sách này sẽ giúp bé mường tượng rõ ràng hơn.','25/11/2015',NULL,'Sách văn học tiểu thuyết',20),('VH008','Tập Tục Quê Em - Làng Quan Họ','Nấm Hương - Thùy An ',50,17000,'Bé Cải rất ngạc nhiên khi phát hiện bà của mình có chiếc áo dài nhiều lớp với màu sắc rất đẹp, lại giống như của cô ca sĩ trên tivi. Rồi còn khăn mỏ quạ và thắt lưng lụa nữa. Thì ra khi còn trẻ, bà của Cải từng tham gia nhóm hát quan họ. Để giải thích cho Cải hiểu rõ hơn về quan họ Bắc Ninh, bà dẫn Cải đến hội Lim. Và Cải mê tít ngày hội truyền thống đặc trưng của vùng Kinh Bắc này.','25/11/2015',NULL,'Sách văn học tiểu thuyết',20),('VH009','Có Ai Yêu Em Như Anh (Tái Bản 2015)','Minh Moon',50,67000,'Buổi tối ấy, trên sân thượng của một nhà hàng lộng gió và thoảng mùi thơm hoa sữa gợi nhớ về ngôi nhà thời thơ ấu nơi phố cũ, anh đã gặp cô. Gió thổi rất mạnh, những sợi tơ hồng đung đưa, đám khách nhốn nháo… Tất cả đều động, duy chỉ có khuôn mặt ấy là tĩnh lặng như hồ nước mùa thu dưới ánh trăng. Buổi tối khác, giữa hơi rượu vấn vít, anh lại thấy cô, đang dìu một người đàn ông ngoại quốc đi tìm phòng trong một khách sạn năm sao. Anh nghĩ, hóa ra, cũng chỉ là hạng con gái đến thế mà thôi. Rồi anh lại thấy cô, trong khoảnh khắc cô nằm say ngủ trên giường, rèm mi như cánh bướm và mái tóc đen dài xõa tung trên chiếc gối trắng. Lần đầu tiên trong đời anh tự nhủ nếu như lấy vợ, mỗi sáng cùng nhau thức dậy trên chiếc giường này thật không tệ chút nào… Anh và cô, hai con người ở hai địa vị khác nhau nhưng nếu đã là tình yêu thì dù đối tượng của bạn là ai, mọi thứ sẽ rất đơn giản. Có ai yêu em như anh! là một câu chuyện tình yêu thi vị mang đến cho bạn đủ các cung bậc cảm xúc. Giống như một viên sô cô la, ban đầu là hương thơm quyến rũ khiến bạn ngất ngây, sau đó là vị đắng có thể khiến bạn chảy nước mắt nhưng trên hết vẫn là dư vị ngọt ngào bạn nhớ mãi không quên!','25/11/2015',NULL,'Sách văn học tiểu thuyết',20),('VH010','Giai Điệu Cho Trái Tim Tan Vỡ','Cathy Hopkins ',50,55000,'\"...nếu cứ mãi khổ sở vì mọi chuyện không theo ý muốn của mình thì chỉ càng mất thời gian mà thôi. Nếu gặp khó khăn, hoặc là bạn sẽ bị nhấn chìm hoặc bạn phải tự bơi. \"  Câu chuyện bắt đầu khi cô bé Paige được bố mẹ thông báo gia đình họ đã phá sản. Những khó khăn liên tiếp ập xuống gia đình Paige. Tuy nhiên, trái tim nhạy cảm của Paige đã không quỵ ngã trước những biến cố khủng khiếp đó. Cô bé bắt đầu làm quen với cuộc sống mới ở Bath, một thành phố nhỏ tuy khác xa London. Cô khám phá những điều thú vị bằng tâm hồn trong trẻo và làm mới cuộc sống của mình. Và rồi, một chiếc đĩa nhạc trong cửa hàng từ thiện lạc vào tay Paige đã sưởi ấm trái tim cô bé và mang đến một tình yêu nhiệm màu.','25/11/2015',NULL,'Sách văn học tiểu thuyết',20);
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thanhvien`
--

DROP TABLE IF EXISTS `thanhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thanhvien` (
  `idthanhvien` varchar(45) NOT NULL,
  `tenthanhvien` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `tinhtrang` varchar(45) NOT NULL,
  `ngaythem` varchar(45) NOT NULL,
  `ngaycapnhat` varchar(45) DEFAULT NULL,
  `gioitinh` varchar(45) NOT NULL,
  PRIMARY KEY (`idthanhvien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thanhvien`
--

LOCK TABLES `thanhvien` WRITE;
/*!40000 ALTER TABLE `thanhvien` DISABLE KEYS */;
INSERT INTO `thanhvien` VALUES ('U001','Lê Nguyên Khuê','khueln3@gmail.com','1994-08-17','Closed','25/11/2015',NULL,'Nam'),('U002','Nguyễn Huy Hoàng','huyhoang@gmail.com','1994-08-17','Closed','25/11/2015',NULL,'Nam'),('U003','Trần Ngọc Hoàng','ngochoang@gmail.com','1994-08-17','Closed','25/11/2015',NULL,'Nam'),('U004','Lưu Xuân Giáp','giapluu@gmail.com','1991-08-17','Closed','25/11/2015',NULL,'Nam'),('U005','Trịnh Hồng Nhân','hongnhan@gmail.com','1993-08-17','Closed','25/11/2015',NULL,'Nam'),('U006','Nguyễn Thị Thúy Giang','thuygiang@gmail.com','1994-08-17','Closed','25/11/2015',NULL,'Nữ'),('U007','Nguyễn Thị Hoàng Anh','hoanganh@gmail.com','1994-08-17','Closed','25/11/2015',NULL,'Nữ'),('U008','Trần Sỹ Tài','sytai@gmail.com','1994-08-17','Active','25/11/2015',NULL,'Nam'),('U009','Trương Công Tuấn','congtuan@gmail.com','1994-08-17','Active','25/11/2015',NULL,'Nam'),('U010','Nguyễn Văn Tiến','tienguyen@gmail.com','1994-08-17','Closed','25/11/2015',NULL,'Nam'),('U011','Đặng Việt Khang','vietkhang@gmail.com','1994-08-17','Closed','25/11/2015',NULL,'Nam'),('U012','Võ Minh Trí','minhtri@gmail.com','1994-08-17','Active','25/11/2015',NULL,'Nam'),('U013','Nguyễn Tấn Phát','tanphat@gmail.com','1994-08-17','Active','25/11/2015',NULL,'Nam'),('U014','Lê Hà Sơn Văn Quốc Huy','quochuy@gmail.com','1994-08-17','Active','25/11/2015',NULL,'Nam'),('U015','Đào Quang Chiến','quangchien@gmail.com','1994-08-17','Closed','25/11/2015',NULL,'Nam'),('U016','Hoàng Võ Nhật Khoa','nhatkhoa@gmail.com','1994-08-17','Closed','25/11/2015',NULL,'Nam'),('U017','Trần Đắc Thắng','dacthang@gmail.com','1994-08-17','Active','25/11/2015',NULL,'Nam'),('U018','Phan Thanh Tâm','thanhtam@email.com','1994-08-17','Active','25/11/2015',NULL,'Nam'),('U019','Nguyễn Hà Trọng Tuấn','trongtuan@email.com','1994-08-17','Active','25/11/2015',NULL,'Nam'),('U020','Ngô Minh Tân','minhtan@email.com','1994-08-17','Active','25/11/2015',NULL,'Nam');
/*!40000 ALTER TABLE `thanhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongtinmuontra`
--

DROP TABLE IF EXISTS `thongtinmuontra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thongtinmuontra` (
  `idthongtinmuontra` int(11) NOT NULL AUTO_INCREMENT,
  `ngaymuon` date NOT NULL,
  `ngayhethan` date NOT NULL,
  `trangthai` varchar(45) NOT NULL,
  `ngaytra` date DEFAULT NULL,
  `phat` varchar(200) DEFAULT NULL,
  `idsach` varchar(45) DEFAULT NULL,
  `idthanhvien` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idthongtinmuontra`),
  KEY `idsach_idx` (`idsach`),
  KEY `idthanhvien_idx` (`idthanhvien`),
  CONSTRAINT `FKimhcry6sqpke4cdidxfpmefd0` FOREIGN KEY (`idthanhvien`) REFERENCES `thanhvien` (`idthanhvien`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FKqbgd33gjt41fghaqcbsr6p8fd` FOREIGN KEY (`idsach`) REFERENCES `sach` (`idsach`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongtinmuontra`
--

LOCK TABLES `thongtinmuontra` WRITE;
/*!40000 ALTER TABLE `thongtinmuontra` DISABLE KEYS */;
INSERT INTO `thongtinmuontra` VALUES (1,'2015-11-25','2016-01-25','Đang mượn',NULL,NULL,'IT001','U001'),(2,'2015-11-24','2016-01-24','Đang mượn',NULL,NULL,'IT002','U001'),(3,'2015-11-23','2016-01-23','Đang mượn',NULL,NULL,'IT003','U001'),(4,'2015-11-22','2016-01-22','Đang mượn',NULL,NULL,'IT004','U001'),(5,'2015-11-21','2016-01-21','Đang mượn',NULL,NULL,'VH001','U002'),(6,'2015-11-20','2016-01-20','Đang mượn',NULL,NULL,'VH001','U003'),(7,'2015-11-19','2016-01-19','Đang mượn',NULL,NULL,'VH009','U004'),(8,'2015-11-18','2016-01-18','Đang mượn',NULL,NULL,'IT001','U004'),(9,'2015-11-17','2016-01-17','Đang mượn',NULL,NULL,'VH007','U005'),(10,'2015-11-16','2016-01-16','Đang mượn',NULL,NULL,'VH009','U006'),(11,'2015-11-15','2016-01-15','Đang mượn',NULL,NULL,'IT005','U006'),(12,'2015-11-14','2016-01-14','Đang mượn',NULL,NULL,'IT003','U006'),(13,'2015-11-13','2016-01-13','Đang mượn',NULL,NULL,'IT009','U007'),(14,'2015-11-12','2016-01-12','Đang mượn',NULL,NULL,'VH010','U010'),(15,'2015-11-11','2016-01-11','Đang mượn',NULL,NULL,'VH008','U011'),(16,'2015-11-10','2016-01-10','Đang mượn',NULL,NULL,'VH008','U015'),(17,'2015-11-09','2016-01-09','Đang mượn',NULL,NULL,'VH008','U016'),(23,'2015-12-19','2016-01-18','Đang Mượn',NULL,NULL,'IT004','U001');
/*!40000 ALTER TABLE `thongtinmuontra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `role` varchar(45) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','123','Nguyên Khuê','ROLE_BOSS',1),(2,'nguyenkhue','123','Lê Nguyên Khuê','ROLE_SLAVE',1),(3,'hoangtran','123','Trần Ngọc Hoàng','ROLE_SLAVE',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-20 14:52:26
