package manager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ComputerMercsDao;
import entity.ComputerMercsEntity;

@Service
public class ComputerMercsManager {

	ComputerMercsDao computerMercsDao;
	
	@Autowired
	public void setComputerMercDao(ComputerMercsDao computerMercsDao){
		this.computerMercsDao = computerMercsDao;
	}
	
	public ComputerMercsDao getComputerMercsDao(){
		return this.computerMercsDao;
	}


    @Transactional
    public void addComputerMerc(ComputerMercsEntity computerMerc) {
    	computerMercsDao.addComputerMercs(computerMerc);
    }
 
 
    @Transactional
    public List getAllComputerMercs() {
        return computerMercsDao.getAllComputerMercs();
    }
 
 
    @Transactional
    public void deleteComputerMerc(Integer computerMerc) {
    	computerMercsDao.deleteComputerMercs(computerMerc);
    }
	
	
}
