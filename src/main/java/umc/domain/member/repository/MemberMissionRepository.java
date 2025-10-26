package umc.domain.member.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.domain.member.entity.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    @Query("""
        select mm
        from MemberMission mm
        join mm.mission m
        join m.store s
        where mm.member.id = :memberId
          and mm.state in ('RUNNING', 'SUCCESS')
        order by mm.deadline asc
    """)
    List<MemberMission> findActiveOrCompletedMissionsOrderByDeadline(
            @Param("memberId") Long memberId
    );
   /* Page<MemberMission> findActiveOrCompletedMissionsOrderByDeadline(
            @Param("memberId") Long memberId,
            Pageable pageable
    );*/
    //아직 Service를 안만들어서 Pageable를 쓸 수가 없다.
}
