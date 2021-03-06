package com.comp62542.backend.patterns.iterators;

import com.comp62542.backend.dao.UserMapper;
import com.comp62542.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component
public class UnregisteredStudentsRespository implements Container{

    @Autowired
    private UserMapper userMapper;

    public User[] students;

    @PostConstruct
    public void init() {
        students = userMapper.selectUnRegisteredStudent();
    }

    @Override
    public Iterator getIterator() {
        return new UnregisterStudentsIterator();
    }

    @Component
    private class UnregisterStudentsIterator implements Iterator {
        int index;

        public UnregisterStudentsIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < students.length;
        }

        @Override
        public User next() {
            if(this.hasNext()) {
                return students[index++];
            }
            return null;
        }
    }
}
