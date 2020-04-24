package my.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lishuai47
 * @date 2020/4/15 11:05
 * @description 位运算
 */
@Slf4j
public class BitwiseAlgorithm {

    public static void main(String[] args) {
        BitwiseAlgorithm ba = new BitwiseAlgorithm();

        ba.model(10,3);
        ba.model(11,4);
        ba.model(11,4);
    }

    /*
       取模(取余)
     */
    public void model(Integer data, Integer factor){

        int remainder = data & (factor - 1);
        log.info("取模运算 {}%{} = {}",data,factor,remainder);
    }



}
