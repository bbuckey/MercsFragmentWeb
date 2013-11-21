package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;

import org.apache.commons.dbcp.DelegatingConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.commons.dbcp.DelegatingCallableStatement;
import org.apache.commons.dbcp.DelegatingPreparedStatement;

public abstract class BaseDAO {

	private SessionFactory sessionFactory;

	private DataSource dataSource;

	public BaseDAO() {
		;
	}

	public BaseDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public void setSessionFactory(
			@Qualifier("session") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public final void cleanupConnection() throws Exception {
		if (this.dataSource != null
				&& !this.dataSource.getConnection().isClosed()) {
			this.dataSource.getConnection().close();
			this.dataSource = null;
			this.sessionFactory = null;
		}
	}

	@SuppressWarnings("deprecation")
	public final CallableStatement createCallableStatement(final String sql)
			throws Exception {
		CallableStatement cs;
		if (dataSource.getConnection() != null
				&& !dataSource.getConnection().isClosed()) {
			cs = (DelegatingCallableStatement) ((DelegatingConnection) this.dataSource
					.getConnection()).getInnermostDelegate().prepareCall(sql);
		} else {
			cs = (DelegatingCallableStatement) ((DelegatingConnection) this.sessionFactory
					.getCurrentSession().connection()).getInnermostDelegate()
					.prepareCall(sql);
		}
		cs.closeOnCompletion();
		return cs;
	}

	@SuppressWarnings("deprecation")
	public final PreparedStatement createPreparedStatement(final String sql)
			throws Exception {
		PreparedStatement ps;
		if (dataSource.getConnection() != null
				&& !dataSource.getConnection().isClosed()) {
			ps = (DelegatingPreparedStatement) ((DelegatingConnection) this.dataSource
					.getConnection()).getInnermostDelegate().prepareStatement(
					sql);
		} else {
			ps = (DelegatingPreparedStatement) ((DelegatingConnection) this.sessionFactory
					.getCurrentSession().connection()).getInnermostDelegate()
					.prepareStatement(sql);
		}
		ps.closeOnCompletion();
		return ps;
	}

	public static final void cleanupCallableStatement(final CallableStatement cs)
			throws Exception {
		if (cs != null && !cs.isClosed()) {
			cs.close();
		}
	}

	public static final void cleanupPreparedStatement(final PreparedStatement ps)
			throws Exception {
		if (ps != null && !ps.isClosed()) {
			ps.close();
		}
	}

	public static final void cleanupResultSet(final ResultSet rs)
			throws Exception {
		if (rs != null && !rs.isClosed()) {
			rs.close();
		}
	}
	
	public static final void cleanupStatement(final Statement s)
			throws Exception {
		if (s != null && !s.isClosed()) {
			s.close();
		}
	}

}
