/*
 * This software code is (c) 2010 T-Mobile USA, Inc. All Rights Reserved.
 *
 * Unauthorized redistribution or further use of this material is
 * prohibited without the express permission of T-Mobile USA, Inc. and
 * will be prosecuted to the fullest extent of the law.
 *
 * Removal or modification of these Terms and Conditions from the source
 * or binary code of this software is prohibited.  In the event that
 * redistribution of the source or binary code for this software is
 * approved by T-Mobile USA, Inc., these Terms and Conditions and the
 * above copyright notice must be reproduced in their entirety and in all
 * circumstances.
 *
 * No name or trademarks of T-Mobile USA, Inc., or of its parent company,
 * Deutsche Telekom AG or any Deutsche Telekom or T-Mobile entity, may be
 * used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" AND "WITH ALL FAULTS" BASIS
 * AND WITHOUT WARRANTIES OF ANY KIND.  ALL EXPRESS OR IMPLIED
 * CONDITIONS, REPRESENTATIONS OR WARRANTIES, INCLUDING ANY IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR
 * NON-INFRINGEMENT CONCERNING THIS SOFTWARE, ITS SOURCE OR BINARY CODE
 * OR ANY DERIVATIVES THEREOF ARE HEREBY EXCLUDED.  T-MOBILE USA, INC.
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY
 * LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE
 * OR ITS DERIVATIVES.  IN NO EVENT WILL T-MOBILE USA, INC. OR ITS
 * LICENSORS BE LIABLE FOR LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
 * INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES,
 * HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT
 * OF THE USE OF OR INABILITY TO USE THIS SOFTWARE, EVEN IF T-MOBILE USA,
 * INC. HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * THESE TERMS AND CONDITIONS APPLY SOLELY AND EXCLUSIVELY TO THE USE,
 * MODIFICATION OR DISTRIBUTION OF THIS SOFTWARE, ITS SOURCE OR BINARY
 * CODE OR ANY DERIVATIVES THEREOF, AND ARE SEPARATE FROM ANY WRITTEN
 * WARRANTY THAT MAY BE PROVIDED WITH A DEVICE YOU PURCHASE FROM T-MOBILE
 * USA, INC., AND TO THE EXTENT PERMITTED BY LAW.
 */

package javax.microedition.ims.im;

/**
 * The ChatInvitation interface represents an invitation to set up a chat 
 * with another IM user. A chat always consists of only two participants 
 * (One-to-One session) with no conference server involved. However, 
 * if additional participants are invited, the chat is replaced by a conference.
 * <p/>
 * Chat invitations are sent using the ConferenceManager interface. 
 * Incoming chat invitations are received through the ConferenceManagerListener interface. 
 */
public interface ChatInvitation {
    
    /**
     * Accepts the chat invitation. Accepting this invitation will cause it 
     * to expire.  The invitation will also expire if it has been rejected, 
     * timed out, or if the Service has been closed. The invitation is always 
     * considered expired if the chatStartFailed event in 
     * the ConferenceManagerListener has been invoked with the given session identifier.
     * 
     * @throws IllegalStateException - if this invitation has expired
     */
    void accept();
    
    /**
     * Rejects the chat invitation. Rejecting this invitation will cause it 
     * to expire.  The invitation will also expire if it has been accepted, 
     * timed out, or if the Service has been closed. The invitation is always 
     * considered expired if the chatStartFailed event in 
     * the ConferenceManagerListener has been invoked with the given session identifier.
     * 
     * @throws IllegalStateException - if this invitation has expired
     */
    void reject();

    /**
     * Returns the identifier of the chat session.
     * 
     * @return the session identifier
     */
    String getSessionId();
    
    /**
     * Returns the sender of this ChatInvitation.
     * 
     * @return the user identity of the sender
     */
    String getSender();

    /**
     * Returns the subject of the chat.
     * 
     * @return the subject, or null  if the subject has not been set
     */
    String getSubject();

}