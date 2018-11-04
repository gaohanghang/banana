package top.ghang.banana.standard;

import java.util.logging.Logger;

/**
 * @author: Gao HangHang
 * @date 2018/10/27
 */
public class test {
    private static final Logger logger = Logger.getLogger("BANANA");
    private static final String TEST_1 = "哈哈哈";

    public static void main(String[] args) {
        logger.info("(Test String)");
        logger.info(BananaUtils.bananaify(TEST_1));

        System.out.println(BananaUtils.bananaify(TEST_1));
    }

}
