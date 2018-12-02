/*
 * =============================================================================
 *
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package business;

import business.entity.Car;
import business.entity.CarStopPos;
import business.entity.repositories.CarRepositories;
import business.entity.repositories.CarStopPosRepositories;
import business.entity.repositories.JdbcActualPositionDao;
import business.util.MyDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Configuration
@ComponentScan
@EnableAsync
public class SpringBusinessConfig {

    public SpringBusinessConfig() {
        super();
    }

    // Nothing else to be configured here: component scanning will do everything needed

    @Bean
    public MyDateFormat mydateFormat(){
        return new MyDateFormat("yyyy-MM-dd");
    }

    @Bean
    @Primary
    public DateFormat dateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @Bean(name = "GMT")//用来转换格林时间GreenwichMeanTime
    public DateFormat dateFormat1(){
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    }

    @Autowired
    public void JdbcTableConfig(JdbcActualPositionDao positionDao){//在开始运行程序的时候检查是否已经建表
        positionDao.createTableByName(mydateFormat().myformat());
    }

    @Bean(name = "ThreadPool")
    public TaskExecutor createTaskExecutor(){
        return new ThreadPoolTaskExecutor();
    }

    @Autowired
    public void createCarStopData(CarRepositories carRepositories, CarStopPosRepositories carStopPosRepositories){
        List<Car> cars = carRepositories.findAll();
        for (Car car: cars){
            if(car.getCarStopPos() == null)
                car.setCarStopPos(new CarStopPos(car));
                carRepositories.save(car);
        }
    }
    
}
