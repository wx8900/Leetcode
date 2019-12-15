package onsite.standardcharteredbank;

/**
 * 一个长度单位转化和计算工具，能够把不同的长度单位转换为标准长度（米），并且可以在不同单位之间进行加减运算。
 *
 * @author Jeff
 * @version V1.0
 * @date 2019/12/2 17:02
 */
public class StandardTest {

    public static void main(String[] args) {
        //转换小工具关键代码

    //建立各种长度单位与m之间的映射
    /*Dictionary<string, string> milearray = new Dictionary<string, string> { };
            milearray.Add("miles", "1609.344");
            milearray.Add("mile", "1609.344");

            milearray.Add("yard", "0.9144");
            milearray.Add("yards", "0.9144");

            milearray.Add("inche", "0.00254");
            milearray.Add("inches", "0.00254");

            milearray.Add("feet", "0.03048");
            milearray.Add("foot", "0.03048");

            milearray.Add("fath", "1.8288");
            milearray.Add("faths", "1.8288");

            milearray.Add("furlong", "201.17");

            //读取input.txt源文件，SInpath是根据用户选择的位置得到
            string testPath = sInpath;
            StreamReader sr = File.OpenText(testPath);

            //从input.txt中获得的每一行文本
            string inputText;

            if (File.Exists(sOutpath))
            {
                File.Delete(sOutpath);
            }

            //定义输出文件的位置，同时先写入邮箱信息和空格
            StreamWriter sw = File.AppendText(sOutpath);
            sw.Write("junbyxzb_2010@163.com" + "\r\n");
            sw.Write("\r\n");
            sw.Close();


            while ((inputText = sr.ReadLine()) != null)
            {
                //去除空格之后的字符串数组
                string[] mile = inputText.Split(' ');

                //计算之后的最终字符串结果
                string outputValue = string.Empty;

                //获取每个长度单位转换之后的值以及该数值之前的运算符号如["201.17","+"]
                Dictionary<double, string> dlist = new Dictionary<double, string> { };

                //单位长度计算的值，包括加减乘除运算
                double sum = 0.0;

                for (int i = 0; i < mile.Length; i++)
                {
                    if (milearray.ContainsKey(mile[i]))
                    {
                        //根据不同单位转换规则，将单位转换成米
                        double value = Double.Parse(milearray[mile[i]]);

                        //转换之后的结果
                        double outputDouble = Double.Parse(mile[i - 1]) * value;

                        //将数值和前面的运算符存入表中
                        if (i > 1)
                        {
                            dlist.Add(outputDouble, mile[i - 2]);
                        }
                        else
                        {
                            dlist.Add(outputDouble, string.Empty);
                        }

                    }
                }

                //完成不同单位之间的计算
                foreach (KeyValuePair<double, string> d in dlist)
                {
                    //数值
                    double value = Double.Parse(d.Key.ToString());

                    //运算符
                    string s = d.Value.ToString();

                    if (s == "+")
                    {
                        sum = sum + value;
                    }
                    else if (s == "-")
                    {
                        sum = sum - value;
                    }
                    else if (s == "*")
                    {
                        sum = sum * value;
                    }
                    else if (s == "/")
                    {
                        sum = sum / value;
                    }
                    else
                    {
                        sum = value;
                    }
                }

                //将结果以保留两位小数，以及在起后加上空格和m的方式输出到output.txt文件中
                outputValue = sum.ToString("0.00") + " " + "m";

                StreamWriter sw1 = File.AppendText(sOutpath);
                sw1.Write(outputValue + "\r\n");
                sw1.Close();
            }

            MessageBox.Show("恭喜转换成功！");*/
    }

}
