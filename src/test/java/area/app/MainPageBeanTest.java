package area.app;

import area.data.AreaDotData;
import area.data.HitCheckData;
import area.data.HitCheckServiceBean;
import area.script.HitCheckScriptBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MainPageBeanTest {

    @Mock
    private HitCheckServiceBean hitCheckService;

    @Mock
    private HitCheckScriptBean hitCheckScript;

    @InjectMocks
    private MainPageBean mainPageBean;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        List<HitCheckData> results = new ArrayList<>();

        when(hitCheckService.getAll()).thenReturn(results);

        doAnswer(invocation -> {
            HitCheckData arg = invocation.getArgument(0);
            results.add(arg);
            return null;
        }).when(hitCheckService).add(any(HitCheckData.class));

        doAnswer(invocation -> {
            results.clear();
            return null;
        }).when(hitCheckService).clean();
    }

    @Test
    void testUpdateResultsList() {
        HitCheckData hitCheckData1 = new HitCheckData(null, 100L, null, false);
        HitCheckData hitCheckData2 = new HitCheckData(null, 200L, null, false);
        HitCheckData hitCheckData3 = new HitCheckData(null, 300L, null, false);
        when(hitCheckService.getAll()).thenReturn(new ArrayList<>(List.of(hitCheckData1, hitCheckData2, hitCheckData3)));

        mainPageBean.updateResultsList();

        assertThat(mainPageBean.getResultsList()).containsExactly(hitCheckData3, hitCheckData2, hitCheckData1);
        verify(hitCheckService).getAll();
    }

    @Test
    void testCheckHit() {
        HitCheckData hitCheckData = new HitCheckData(null, 100L, null, false);
        when(hitCheckScript.execute(any(AreaDotData.class))).thenReturn(hitCheckData);

        mainPageBean.checkHit();

        verify(hitCheckService).add(hitCheckData);
        assertThat(mainPageBean.getResultsList().size()).isEqualTo(1);
        assertThat(mainPageBean.getResultsList().get(0)).isEqualTo(hitCheckData);
    }

    @Test
    void testCleanResults() {
        HitCheckData hitCheckData1 = new HitCheckData(null, 100L, null, false);
        HitCheckData hitCheckData2 = new HitCheckData(null, 200L, null, false);
        HitCheckData hitCheckData3 = new HitCheckData(null, 300L, null, false);
        when(hitCheckScript.execute(any(AreaDotData.class))).thenReturn(hitCheckData1, hitCheckData2, hitCheckData3);

        mainPageBean.checkHit();
        mainPageBean.checkHit();
        mainPageBean.checkHit();

        assertThat(mainPageBean.getResultsList().size()).isEqualTo(3);

        mainPageBean.cleanResults();

        verify(hitCheckService).clean();
        assertThat(mainPageBean.getResultsList()).isEmpty();
    }
}
