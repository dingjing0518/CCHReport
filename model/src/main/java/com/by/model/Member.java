package com.by.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.by.json.MemberRequestJson;
import com.by.typeEnum.ValidEnum;

@Entity
@Table(name = "by_member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Length(max = 11, min = 11)
	private String name;
	
	//身份证号
	private String ic;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "card_id")
	private Card card;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,CascadeType.MERGE })
	@JoinColumn(name = "detail_id")
	private MemberDetail memberDetail;

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
	private List<ShopCouponMember> shopCoupons;

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
	private List<GiftCouponMember> coupons;

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
	private List<ParkingCouponMember> parkingCoupons;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "by_member_license", joinColumns = @JoinColumn(name = "member_id") , inverseJoinColumns = @JoinColumn(name = "license_id") )
	private List<License> licenses;

	// 可用积分
	private int score;

	// 总积分
	private int sumScore;

	@Enumerated
	private ValidEnum valid;

	// 注册时间
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time")
	private Calendar createdTime;

	@Column(name = "created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_time")
	private Calendar updatedTime;

	@Column(name = "updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "invalid_time")
	private Calendar inValidTime;

	@Column(name = "invalid_by")
	private String inValidBy;

	public Member() {
	}

	public Member(Long id) {
		this.id = id;
	}

	public Member(MemberRequestJson json) {
		this.name = json.getName();
		this.card = new Card(json.getCard());
	}

	public Member(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Calendar getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}

	public List<GiftCouponMember> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<GiftCouponMember> coupons) {
		this.coupons = coupons;
	}

	public MemberDetail getMemberDetail() {
		return memberDetail;
	}

	public void setMemberDetail(MemberDetail memberDetail) {
		this.memberDetail = memberDetail;
	}

	public List<ShopCouponMember> getShopCoupons() {
		return shopCoupons;
	}

	public void setShopCoupons(List<ShopCouponMember> shopCoupons) {
		this.shopCoupons = shopCoupons;
	}

	public List<License> getLicenses() {
		return licenses;
	}

	public void setLicenses(List<License> licenses) {
		this.licenses = licenses;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ValidEnum getValid() {
		return valid;
	}

	public void setValid(ValidEnum valid) {
		this.valid = valid;
	}

	public Calendar getInValidTime() {
		return inValidTime;
	}

	public void setInValidTime(Calendar inValidTime) {
		this.inValidTime = inValidTime;
	}

	public Calendar getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Calendar updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getInValidBy() {
		return inValidBy;
	}

	public void setInValidBy(String inValidBy) {
		this.inValidBy = inValidBy;
	}

	public int getSumScore() {
		return sumScore;
	}

	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
		
	public String getIc() {
		return ic;
	}
	
	public void setIc(String ic) {
		this.ic = ic;
	}

	@PrePersist
	private void prePersist() {
		this.createdTime = Calendar.getInstance();
	}

	@PreUpdate
	private void preUpdate() {
		this.updatedTime = Calendar.getInstance();
	}

	public boolean isValidMember() {
		return this.getValid().equals(ValidEnum.VALID);
	}

	public List<ParkingCouponMember> getParkingCoupons() {
		return parkingCoupons;
	}

	public void setParkingCoupons(List<ParkingCouponMember> parkingCoupons) {
		this.parkingCoupons = parkingCoupons;
	}

	public static int findSumParkingCouponCount(List<ParkingCouponMember> pcm) {
		Calendar today = Calendar.getInstance();
		return pcm.stream()
				.filter(i -> i.getCoupon().getCouponEndTime() == null
						|| (i.getCoupon().getCouponEndTime() != null && i.getCoupon().isBeforeCouponEndTime(today)))
				.map(i -> i.getTotal()).reduce(0, (i, s) -> i + s);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
