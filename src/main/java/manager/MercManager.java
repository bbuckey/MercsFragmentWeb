package manager;

import dao.MercsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import entity.MercEntity;
import java.util.List;

@Service
public class MercManager {

	private MercsDao mercsDao;
	

    @Transactional
    public void addMerc(MercEntity employee) {
    	mercsDao.addMerc(employee);
    }
 
 
    @Transactional
    public List getAllMercs() {
        return mercsDao.getAllMercs();
    }
 
 
    @Transactional
    public void deleteMerc(Integer employeeId) {
    	mercsDao.deleteMerc(employeeId);
    }

    @Autowired
    public void setMercsDao(MercsDao mercsDao) {
        this.mercsDao = mercsDao;
    }
    

    public MercsDao getMercsDao() {
       return this.mercsDao;
    }
	
}
