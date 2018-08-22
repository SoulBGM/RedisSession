package git.soulbgm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 贺瑞杰
 * @version V1.0
 * @date 2018-08-22 17:06
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{

    private String username;
    private String password;
}
