package com.syh.common.threadPool;

import com.syh.common.util.SerializeUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.io.Serializable;

/**
 * SerializeUtilTest
 *
 * @author HSY
 * @since 2020/07/01 11:39
 */
public class SerializeUtilTest implements Serializable{
    @Test
    public void serialize () {
        Student student = new Student("hsy", 18);
        byte[] studentSerialize = SerializeUtil.serialize(student);
        for (byte b : studentSerialize) {
            System.out.println("b = " + b);
        }
        Student studentDeserialize = (Student) SerializeUtil.deserialize(studentSerialize);
        System.out.println("studentDeserialize = " + studentDeserialize.toString());
    }

    @Data
    @AllArgsConstructor
    class Student implements Serializable {
        String name;

        Integer age;
    }
}
