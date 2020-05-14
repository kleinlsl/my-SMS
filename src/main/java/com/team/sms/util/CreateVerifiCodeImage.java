package com.team.sms.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @project: my-sms
 * @description: 绘制验证码图片
 * @author: dell
 * @date: 2020/5/14 - 16:37
 * @version: 1.0
 * @website:
 */
public class CreateVerifiCodeImage {

    private static int WIDTH = 90;
    private static int HEIGHT = 35;
    private static int FONT_SIZE = 20; //字符大小
    private static char[] verifiCode; //验证码
    private static BufferedImage verifiCodeImage; //验证码图片


    public static BufferedImage getVerifiCodeImage() {
        /**
         * @description: 获取验证码图片
         * @param: []
         * @date: 2020/5/14 - 16:38
         * @return: java.awt.image.BufferedImage
         */
        verifiCodeImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);// create a image
        Graphics graphics = verifiCodeImage.getGraphics();

        verifiCode = generateCheckCode();
        drawBackground(graphics);
        drawRands(graphics, verifiCode);

        graphics.dispose();

        return verifiCodeImage;
    }


    public static char[] getVerifiCode() {
        /**
         * @description: 获取验证码
         * @param: []
         * @date: 2020/5/14 - 16:39
         * @return: char[]
         */
        return verifiCode;
    }


    private static char[] generateCheckCode() {
        /**
         * @description: 随机生成验证码
         * @param: []
         * @date: 2020/5/14 - 16:39
         * @return: char[]
         */
        String chars = "0123456789abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] rands = new char[4];
        for (int i = 0; i < 4; i++) {
            int rand = (int) (Math.random() * (10 + 26 * 2));
            rands[i] = chars.charAt(rand);
        }
        return rands;
    }

    private static void drawRands(Graphics g, char[] rands) {
        /**
         * @description: 绘制验证码
         * @param: [g, rands]
         * @date: 2020/5/14 - 16:39
         * @return: void
         */
        g.setFont(new Font("Console", Font.BOLD, FONT_SIZE));

        for (int i = 0; i < rands.length; i++) {

            g.setColor(getRandomColor());
            g.drawString("" + rands[i], i * FONT_SIZE + 10, 25);
        }
    }

    private static void drawBackground(Graphics g) {
        /**
         * @description: 绘制验证码图片背景
         * @param: [g]
         * @date: 2020/5/14 - 16:40
         * @return: void
         */
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // 绘制验证码干扰点
        for (int i = 0; i < 200; i++) {
            int x = (int) (Math.random() * WIDTH);
            int y = (int) (Math.random() * HEIGHT);
            g.setColor(getRandomColor());
            g.drawOval(x, y, 1, 1);

        }
    }


    private static Color getRandomColor() {
        /**
         * @description: 获取随机颜色
         * @param: []
         * @date: 2020/5/14 - 16:40
         * @return: java.awt.Color
         */
        Random ran = new Random();
        return new Color(ran.nextInt(220), ran.nextInt(220), ran.nextInt(220));
    }

}
