package com.egov.tendering.bidding.dal.model;

/**
 * Enum representing the types of compliance requirements for a tender.
 */
public enum RequirementType {
    /**
     * Requires submission of specific documents (e.g., certifications, licenses).
     */
    DOCUMENT,

    /**
     * Requires specific bid items or criteria to be addressed.
     */
    BID_ITEM,

    /**
     * Requires a bid security (e.g., bank guarantee, bid bond).
     */
    BID_SECURITY,

    /**
     * Requires tenderer qualifications (e.g., experience, certifications).
     */
    QUALIFICATION,

    /**
     * Other unspecified compliance requirements.
     */
    OTHER
}