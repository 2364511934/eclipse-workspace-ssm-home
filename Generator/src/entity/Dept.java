package entity;

public class Dept {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dept.deptno
     *
     * @mbggenerated Tue Jan 30 17:22:11 CST 2018
     */
    private Integer deptno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dept.dname
     *
     * @mbggenerated Tue Jan 30 17:22:11 CST 2018
     */
    private String dname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dept.loc
     *
     * @mbggenerated Tue Jan 30 17:22:11 CST 2018
     */
    private String loc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dept.deptno
     *
     * @return the value of dept.deptno
     *
     * @mbggenerated Tue Jan 30 17:22:11 CST 2018
     */
    public Integer getDeptno() {
        return deptno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dept.deptno
     *
     * @param deptno the value for dept.deptno
     *
     * @mbggenerated Tue Jan 30 17:22:11 CST 2018
     */
    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dept.dname
     *
     * @return the value of dept.dname
     *
     * @mbggenerated Tue Jan 30 17:22:11 CST 2018
     */
    public String getDname() {
        return dname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dept.dname
     *
     * @param dname the value for dept.dname
     *
     * @mbggenerated Tue Jan 30 17:22:11 CST 2018
     */
    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dept.loc
     *
     * @return the value of dept.loc
     *
     * @mbggenerated Tue Jan 30 17:22:11 CST 2018
     */
    public String getLoc() {
        return loc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dept.loc
     *
     * @param loc the value for dept.loc
     *
     * @mbggenerated Tue Jan 30 17:22:11 CST 2018
     */
    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }
}