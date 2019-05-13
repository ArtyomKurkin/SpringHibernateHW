package com.netcracker.dao;

import com.netcracker.model.Shop;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository("shopDAO")
@Transactional
public class ShopDAOImpl extends BaseDAOImpl<Shop> implements ShopDAO{


    public List<String> shopFromSormAndSov() {
        Query query = getSession().createQuery("from Shop where district = :district1 or district = :district2");
        query.setString("district1","Sormovskiy");
        query.setString("district2","Sovetskiy");
        List<String> result  = new ArrayList<String>();
        for (Shop shop : (List<Shop>)query.list()){
            String name = shop.getTitle();
            result.add(name);
        }
        return result;
    }

    public void updateById(int id, Shop shop){
        Query query = getSession().createQuery("update Shop set title = :title, district = :district, comission = :comission where id = :id");
        query.setInteger("id",id);
        query.setString("title",shop.getTitle());
        query.setString("district", shop.getDistrict());
        query.setInteger("comission", shop.getComission());
        query.executeUpdate();
    }
}
