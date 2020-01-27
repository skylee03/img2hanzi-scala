import javax.imageio.ImageIO
import java.io._

object Main {
  val s = "丶十大天凹安阿画冒害巢焦盟箍黎霖赢瞿靡鼍霸鬻罐矗戆蠼爨齉"
  def getChar(argb: Int): Char = {
    val a = (argb & 0xff000000) >> 24
    val r = (argb & 0x00ff0000) >> 16
    val g = (argb & 0x0000ff00) >> 8
    val b = (argb & 0x000000ff) >> 0
    if(a == 0) {
      '　'
    } else {
      val gray = 256 - (0.2126 * r + 0.7152 * g + 0.0722 * b).toInt
      s((gray * s.length / 257.0).toInt)
    }
  }
  def main(args: Array[String]) {
    val output = new PrintWriter(new File("output.txt"))
    val img = ImageIO.read(new File("zhzx.jpg"))
    val width = 50
    val height = 50
    val txt = new StringBuilder
    var i=0
    while(i < img.getHeight) {
      var j=0
      while(j < img.getWidth) {
        txt += getChar(img.getRGB(j, i))
        j += img.getWidth / width
      }
      txt += '\n'
      i += img.getHeight / height
    }
    output.print(txt)
    output.close()
  }
}