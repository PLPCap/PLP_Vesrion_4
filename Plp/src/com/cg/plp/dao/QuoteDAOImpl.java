package com.cg.plp.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.plp.bean.AccountCreationBean;
import com.cg.plp.bean.PolicyCreationBean;
import com.cg.plp.bean.PolicyQuestions;
import com.cg.plp.bean.UserLoginBean;
import com.cg.plp.util.DBConnection;

public class QuoteDAOImpl implements IQuoteDAO {

	
	
	
	@Override
	public int checkValidLogin(UserLoginBean userLoginBean) throws SQLException, ClassNotFoundException, FileNotFoundException {
		
		{
			Connection connection=DBConnection.getConnection();
					int role=0;
					
					PreparedStatement preparedStatement=null;
					ResultSet resultset1 = null;
					
					
					    preparedStatement=connection.prepareStatement("select role_code from Login_credentials where user_name=? and password=?");
						preparedStatement.setString(1,userLoginBean.getLoginId());
						preparedStatement.setString(2, userLoginBean.getPassword());
						resultset1=preparedStatement.executeQuery();
						while(resultset1.next())
						{
							role=resultset1.getInt(1);
							
						}
						
						

			return role;				
		}
		//return 1;
	}

	@Override
	public void profileCreation(UserLoginBean userLoginBean) throws ClassNotFoundException, FileNotFoundException, SQLException{
		// TODO Auto-generated method stub
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		//ResultSet resultset2= null;
		
		preparedStatement=connection.prepareStatement("insert into login_credentials values(?,?,?)");
		
		preparedStatement.setString(1, userLoginBean.getLoginId());
		preparedStatement.setString(2, userLoginBean.getPassword());
		preparedStatement.setInt(3, userLoginBean.getRoleCode());
		
		preparedStatement.executeUpdate();
		
		
		
	}

	@Override
	public void accountCreation(AccountCreationBean accountCreationBean) throws ClassNotFoundException, FileNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		int account_number=0;
		
		preparedStatement=connection.prepareStatement("insert into accounts values(?,?,?,?,?,?,?)");
		
		preparedStatement.setDouble(1, accountCreationBean.getAccountNo());
		preparedStatement.setString(2, accountCreationBean.getInsuredName());
		preparedStatement.setString(3, accountCreationBean.getInsuredStreet());
		preparedStatement.setString(4, accountCreationBean.getInsuredCity());
		preparedStatement.setString(5, accountCreationBean.getInsuredState());
		preparedStatement.setInt(6, accountCreationBean.getInsuredZip());
		preparedStatement.setString(7, accountCreationBean.getBusinessSegment());

//		if(resultSet.next())
//		{
//			account_number = resultSet.getInt(1);
//					
//		}
		
		
		preparedStatement.executeUpdate();
	
	}

	@Override
	public void policyCreation(PolicyCreationBean policyCreationBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PolicyQuestions> retrieveAll() throws ClassNotFoundException, FileNotFoundException, SQLException {
		
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		preparedStatement=connection.prepareStatement("select * from policy_questions");
		resultSet=preparedStatement.executeQuery();
		List<PolicyQuestions> policyList = new ArrayList<PolicyQuestions>();
		while(resultSet.next())
		{
			PolicyQuestions policyQuestions=new PolicyQuestions();
			
			policyQuestions.setQuesId(resultSet.getInt(1));
			policyQuestions.setQuesSeq(resultSet.getInt(2));
			policyQuestions.setBusSegId(resultSet.getString(3));
			policyQuestions.setQuesDesc(resultSet.getString(4));
			policyQuestions.setAns1(resultSet.getString(5));
			policyQuestions.setAns2(resultSet.getString(6));
			policyQuestions.setAns3(resultSet.getString(7));
			policyQuestions.setAns4(resultSet.getString(8));
			policyQuestions.setPol_Ques_Ans1_weightage(resultSet.getString(9));
			policyQuestions.setPol_Ques_Ans2_weightage(resultSet.getString(10));
			policyQuestions.setPol_Ques_Ans3_weightage(resultSet.getString(11));
			policyQuestions.setPol_Ques_Ans4_weightage(resultSet.getString(12));
			policyList.add(policyQuestions);
			
		}
		return policyList;
		
//		public List<DonorBean> retriveAllDetails() throws DonorException {
//			
//			Connection con=DBConnection.getInstance().getConnection();
//			int donorCount = 0;
//			
//			PreparedStatement ps=null;
//			ResultSet resultset = null;
//			
//			List<DonorBean> donorList=new ArrayList<DonorBean>();
//			try
//			{
//				ps=con.prepareStatement(QueryMapper.RETRIVE_ALL_QUERY);
//				resultset=ps.executeQuery();
//				
//				while(resultset.next())
//				{	
//					DonorBean bean=new DonorBean();
//					bean.setDonorName(resultset.getString(1));
//					bean.setAddress(resultset.getString(2));
//					bean.setPhoneNumber(resultset.getString(3));
//					bean.setDonationDate(resultset.getDate(4));
//					bean.setDonationAmount(resultset.getDouble(5));
//					donorList.add(bean);a
//					
//					donorCount++;
//				}			
//				
//	}


		
		
	}}
