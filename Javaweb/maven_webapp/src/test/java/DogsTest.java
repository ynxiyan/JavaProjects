import entity.Dogs;
import service.DogsService;
import service.impl.DogsServiceImpl;

/**
 * @Author: XIYAN
 * @Date: 2023/2/16 10:17
 * @注释:
 */
public class DogsTest {
    public static void main(String[] args) {
        Dogs dogs = new Dogs();
        DogsService dogsService = new DogsServiceImpl();
        dogs.setId(6);
        System.out.println(dogsService.getDogsById(dogs));
    }
}
