package leetcode;

/**
 * 自行实现11大排序算法，此类为排序基类。
 * 解析视频：<a href="https://www.bilibili.com/video/BV1Zs4y1X7mN" />
 */
public interface ISort {
    int[] performSort(int[] originArray);
    
    String getSortType();
}