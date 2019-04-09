/**
 * 
 */
package edu.sollers.javaprog.springboot.inventorymgmtspringmvc;

import java.sql;
import java.util.ArrayList;
import java.util.List;


/**
 * @author premit
 *
 */
public class UserConnection extends UserBean {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

//All works of purchase
    public static int savepurchase(User u) {
        int status = 0;

        try {
            Connection con = getConnection();
            PreparedStatement ps1 = con.prepareStatement("insert into purchase(category,dealer_name,code,product_name,company_name,quantity,unit,per_unit_price,product_exp_date,purchase_date) values(?,?,?,?,?,?,?,?,?,?)");
            ps1.setString(1, u.getCategory());
            ps1.setString(2, u.getDealer_name());
            ps1.setString(3, u.getCode());
            ps1.setString(4, u.getProduct_name());
            ps1.setString(5, u.getCompany_name());
            ps1.setString(6, u.getQuantity());
            ps1.setString(7, u.getUnit());
            ps1.setString(8, u.getPer_unit_price());
            ps1.setString(9, u.getProduct_exp_date());
            ps1.setString(10, u.getPurchase_date());
            status = ps1.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int updatepurchase(User u) {
        int status = 0;

        try {
            Connection con = getConnection();

            PreparedStatement ps1 = con.prepareStatement("update purchase set category=?,code=?,product_name=?,company_name=?,quantity=?,unit=?,per_unit_price=?,product_exp_date=?,purchase_date=? where id=?");
            ps1.setString(1, u.getCategory());
            ps1.setString(2, u.getCode());
            ps1.setString(3, u.getProduct_name());
            ps1.setString(4, u.getCompany_name());
            ps1.setString(5, u.getQuantity());
            ps1.setString(6, u.getUnit());
            ps1.setString(7, u.getPer_unit_price());
            ps1.setString(8, u.getProduct_exp_date());
            ps1.setString(9, u.getPurchase_date());
            ps1.setInt(10, u.getId());
            status = ps1.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int deletepurchase(User u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps1 = con.prepareStatement("delete from purchase where id=?");
            ps1.setInt(1, u.getId());
            status = ps1.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }

    public static User getRecordByPurchaseId(int id) {
        User u = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps1 = con.prepareStatement("select * from purchase where id=?");
            ps1.setInt(1, id);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setCategory(rs.getString("category"));
                u.setDealer_name(rs.getString("dealer_name"));
                u.setCode(rs.getString("code"));
                u.setProduct_name(rs.getString("product_name"));
                u.setCompany_name(rs.getString("company_name"));
                u.setQuantity(rs.getString("quantity"));
                u.setUnit(rs.getString("unit"));
                u.setPer_unit_price(rs.getString("per_unit_price"));
                u.setProduct_exp_date(rs.getString("product_exp_date"));
                u.setPurchase_date(rs.getString("purchase_date"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }

//All works of Dealer
    public static int savedealer(User u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into dealership(dealer_name,branch,dealer_id,contact,address,agent_name,agent_contact,date) values(?,?,?,?,?,?,?,?)");
            ps.setString(1, u.getDealer_name());
            ps.setString(2, u.getBranch());
            ps.setString(3, u.getDealer_id());
            ps.setString(4, u.getContact());
            ps.setString(5, u.getAddress());
            ps.setString(6, u.getAgent_name());
            ps.setString(7, u.getAgent_contact());
            ps.setString(8, u.getDate());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int updatedealer(User u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update dealership set dealer_name=?,branch=?,dealer_id=?,contact=?,address=?,agent_name=?,agent_contact=?,date=? where id=?");
            ps.setString(1, u.getDealer_name());
            ps.setString(2, u.getBranch());
            ps.setString(3, u.getDealer_id());
            ps.setString(4, u.getContact());
            ps.setString(5, u.getAddress());
            ps.setString(6, u.getAgent_name());
            ps.setString(7, u.getAgent_contact());
            ps.setString(8, u.getDate());
            ps.setInt(9, u.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int deletedealer(User u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from dealership where id=?");
            ps.setInt(1, u.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }

    public static User getRecordByDealerId(int id) {
        User u = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from dealership where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setDealer_name(rs.getString("dealer_name"));
                u.setBranch(rs.getString("branch"));
                u.setDealer_id(rs.getString("dealer_id"));
                u.setContact(rs.getString("contact"));
                u.setAddress(rs.getString("address"));
                u.setAgent_name(rs.getString("agent_name"));
                u.setAgent_contact(rs.getString("agent_contact"));
                u.setDate(rs.getString("date"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }
//All works of MemberShip
    
    public static int saveMember(User u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into membership(member_id,name,gender,password,email,mobile_no,nid,pre_address,per_address,payment,category,date) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, u.getMember_id());
            ps.setString(2, u.getName());
            ps.setString(3, u.getGender());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getMobile_no());
            ps.setString(7, u.getNid());
            ps.setString(8, u.getPre_address());
            ps.setString(9, u.getPer_address());
            ps.setString(10, u.getPayment());
            ps.setString(11, u.getCategory());
            ps.setString(12, u.getDate());

            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int updateMember(User u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update membership set member_id=?,name=?,gender=?,password=?,email=?,mobile_no=?,nid=?,pre_address=?,per_address=?,payment=?,category=?,date=? where id=?");
            ps.setString(1, u.getMember_id());
            ps.setString(2, u.getName());
            ps.setString(3, u.getGender());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getEmail());
            ps.setString(6, u.getMobile_no());
            ps.setString(7, u.getNid());
            ps.setString(8, u.getPre_address());
            ps.setString(9, u.getPer_address());
            ps.setString(10, u.getPayment());
            ps.setString(11, u.getCategory());
            ps.setString(12, u.getDate());
            ps.setInt(13, u.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int deleteMember(User u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from membership where id=?");
            ps.setInt(1, u.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }

    public static User getRecordMemberById(int id) {
        User u = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from membership where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setMember_id(rs.getString("member_id"));
                u.setName(rs.getString("name"));
                u.setGender(rs.getString("gender"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setMobile_no(rs.getString("mobile_no"));
                u.setNid(rs.getString("nid"));
                u.setPre_address(rs.getString("pre_address"));
                u.setPer_address(rs.getString("per_address"));
                u.setPayment(rs.getString("payment"));
                u.setCategory(rs.getString("category"));
                u.setDate(rs.getString("date"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }

/////////////////////For Staff//////
   public static int saveStaff(User u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into staff(staff_id,password,name,gender,mobile_no,nid,pre_address,per_address,category,date) values(?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1,u.getStaff_id());
                ps.setString(2,u.getPassword());
		ps.setString(3,u.getName());
		ps.setString(4,u.getGender());
                ps.setString(5,u.getMobile_no());
		ps.setString(6,u.getNid());
                ps.setString(7,u.getPre_address());
                ps.setString(8,u.getPer_address());
                ps.setString(9,u.getCategory());
                ps.setString(10,u.getDate());
                
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int updateStaff(User u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("update staff set staff_id=?,password=?,name=?,gender=?,mobile_no=?,nid=?,pre_address=?,per_address=?,category=?,date=? where id=?");
		ps.setString(1,u.getStaff_id());
                ps.setString(2,u. getPassword());
		ps.setString(3,u.getName());
		ps.setString(4,u. getGender());
                ps.setString(5,u.getMobile_no());
		ps.setString(6,u.getNid());
                ps.setString(7,u.getPre_address());
                ps.setString(8,u.getPer_address());
                ps.setString(9,u.getCategory());
                ps.setString(10,u.getDate());
		ps.setInt(11,u.getId());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int deleteStaff(User u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from staff where id=?");
		ps.setInt(1,u.getId());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}

	return status;
}

public static User getStaffRecordMemberById(int id){
	User u=null;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from staff where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			u=new User();
			u.setId(rs.getInt("id"));
			u.setStaff_id(rs.getString("staff_id"));
                        u.setPassword(rs.getString("password"));
			u.setName(rs.getString("name"));
			u.setGender(rs.getString("gender"));                      
			u.setMobile_no(rs.getString("mobile_no"));
                        u.setNid(rs.getString("nid"));
                        u.setPre_address(rs.getString("pre_address"));
			u.setPer_address(rs.getString("per_address"));			
                        u.setCategory(rs.getString("category"));
			u.setDate(rs.getString("date"));
		}
	}catch(Exception e){System.out.println(e);}
	return u;
}

/////////////for sales//////////////

public static int saveSale(User u) {
        int status = 0;

        try {
            Connection con = getConnection();
            PreparedStatement ps1 = con.prepareStatement("insert into sale(code,category,product_name,quantity,unit,per_unit_price,total_price,date) values(?,?,?,?,?,?,?,?)");
            ps1.setString(1, u.getCode());
            ps1.setString(2, u.getCategory());
            ps1.setString(3, u.getProduct_name());
            ps1.setString(4, u.getQuantity());
            ps1.setString(5, u.getUnit());
            ps1.setString(6, u.getPer_unit_price());
            ps1.setString(7, u.getT_Price());
            ps1.setString(8, u.getDate());
            
            status = ps1.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }


public static List<User> getAllSaleRecords(){
	List<User> list=new ArrayList<User>();
	
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from sale");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			User u=new User();
			u.setId(rs.getInt("id"));
			u.setCode(rs.getString("code"));
                        u.setCategory(rs.getString("category"));
                        u.setProduct_name(rs.getString("product_name"));
                        u.setQuantity(rs.getString("quantity"));
                        u.setUnit(rs.getString("unit"));
                        u.setPer_unit_price(rs.getString("per_unit_price"));
                        u.setT_Price(rs.getString("total_price"));
                        u.setDate(rs.getString("date"));
                       
			list.add(u);
		}
	}catch(Exception e){System.out.println(e);}
	return list;
}

public static int deleteSale(User u) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps1 = con.prepareStatement("delete from sale where id=?");
            ps1.setInt(1, u.getId());
            status = ps1.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }






///////for Fetching Supplier Name//////
public static List<User> getAllRecords(){
	List<User> list=new ArrayList<User>();
	
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from dealership");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			User u=new User();
			u.setId(rs.getInt("id"));
			u.setDealer_name(rs.getString("dealer_name"));
			
			
			list.add(u);
		}
	}catch(Exception e){System.out.println(e);}
	return list;
}


}
